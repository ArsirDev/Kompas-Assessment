package com.example.kompasandroidassessment.feature.data.remote.api

import EndPoint.DETAIL_EP
import EndPoint.DETAIL_REPO_EP
import EndPoint.SEARCH_EP
import com.example.kompasandroidassessment.feature.data.remote.dto.SearchResponse
import com.example.kompasandroidassessment.feature.data.remote.dto.DetailResponse
import com.example.kompasandroidassessment.feature.data.remote.dto.RepoResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GithubApi {
    @GET(SEARCH_EP)
    suspend fun getSearchUser(
        @Query("q") username: String,
        @Query("page") page: Int,
        @Query("per_page") per_page: Int
    ): SearchResponse

    @GET(DETAIL_EP)
    suspend fun getUsersDetail(
        @Path("username") username: String
    ) : DetailResponse

    @GET(DETAIL_REPO_EP)
    suspend fun getRepo(
        @Path("username") username: String
    ): RepoResponse
}