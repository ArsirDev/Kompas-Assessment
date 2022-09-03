package com.example.kompasandroidassessment.feature.data.repository

import com.example.kompasandroidassessment.feature.data.remote.api.GithubApi
import com.example.kompasandroidassessment.feature.data.remote.dto.DetailResponse
import com.example.kompasandroidassessment.feature.data.remote.dto.RepoResponse
import com.example.kompasandroidassessment.feature.data.remote.dto.SearchResponse
import com.example.kompasandroidassessment.feature.domain.repository.GithubRepository
import com.example.kompasandroidassessment.utils.Result
import com.example.kompasandroidassessment.utils.unwrapAsFlow
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GithubRepositoryImpl @Inject constructor(
    private val apiService: GithubApi,
) : GithubRepository {
    override fun searchUser(
        username: String,
        page: Int,
        per_page: Int
    ): Flow<Result<SearchResponse>> = unwrapAsFlow {
        apiService.getSearchUser(username,page, per_page)
    }

    override fun userDetail(username: String): Flow<Result<DetailResponse>> = unwrapAsFlow {
        apiService.getUsersDetail(username)
    }

    override fun repoDetail(username: String): Flow<Result<RepoResponse>> = unwrapAsFlow {
        apiService.getRepo(username)
    }
}