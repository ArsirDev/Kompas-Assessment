package com.example.kompasandroidassessment.di

import Keys.AUTH_HEADER
import com.example.kompasandroidassessment.BuildConfig
import com.example.kompasandroidassessment.feature.data.remote.api.GithubApi
import com.example.kompasandroidassessment.feature.data.repository.GithubRepositoryImpl
import com.example.kompasandroidassessment.feature.domain.repository.GithubRepository
import com.example.kompasandroidassessment.feature.domain.usecase.GetDetailUseCase
import com.example.kompasandroidassessment.feature.domain.usecase.GetHomeUseCase
import com.example.kompasandroidassessment.feature.domain.usecase.GetDetailRepoUseCase
import com.example.kompasandroidassessment.feature.domain.usecase.GithubUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import java.util.logging.Level
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun  provideOkHttpClient(): OkHttpClient {
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        return OkHttpClient.Builder()
            .connectTimeout(2, TimeUnit.MINUTES)
            .writeTimeout(2, TimeUnit.MINUTES)
            .readTimeout(2, TimeUnit.MINUTES)
            .addInterceptor { chain ->
                val request = chain.request()
                    .newBuilder()
                    .addHeader("x-localization", "id")
                    .addHeader("Cache-Control", "no-cache")
                    .addHeader("Cache-Control", "no-store")
                    .addHeader("accept", "application/vnd.github+json")
                    .addHeader(AUTH_HEADER, BuildConfig.TOKEN)
                    .build()
                chain.proceed(request)
            }
            .addInterceptor(logging)
            .build()
    }


    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): GithubApi =
        retrofit.create(GithubApi::class.java)

    @Provides
    @Singleton
    fun provideRepository(githubApi: GithubApi): GithubRepository {
        return GithubRepositoryImpl(githubApi)
    }

    @Provides
    @Singleton
    fun provideGithubUseCase(repository: GithubRepository): GithubUseCase {
        return GithubUseCase(
            getHomeUseCase = GetHomeUseCase(repository),
            getDetailUseCase = GetDetailUseCase(repository),
            getDetailRepoUseCase = GetDetailRepoUseCase(repository)
        )
    }

}