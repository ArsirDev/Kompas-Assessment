package com.example.kompasandroidassessment.feature.domain.repository

import com.example.kompasandroidassessment.feature.data.remote.dto.SearchResponse
import com.example.kompasandroidassessment.feature.data.remote.dto.DetailResponse
import com.example.kompasandroidassessment.feature.data.remote.dto.RepoResponse
import com.example.kompasandroidassessment.utils.Result
import kotlinx.coroutines.flow.Flow

interface GithubRepository {

    fun searchUser(username: String, page: Int, per_page: Int): Flow<Result<SearchResponse>>

    fun userDetail(username: String): Flow<Result<DetailResponse>>

    fun repoDetail(username: String): Flow<Result<RepoResponse>>
}