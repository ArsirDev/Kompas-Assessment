package com.example.kompasandroidassessment.feature.domain.usecase

import com.example.kompasandroidassessment.feature.data.remote.dto.SearchResponse
import com.example.kompasandroidassessment.feature.domain.repository.GithubRepository
import com.example.kompasandroidassessment.utils.Result
import kotlinx.coroutines.flow.Flow

class GetHomeUseCase(
    private val repository: GithubRepository
) {
    operator fun invoke(
        username: String,
        page: Int,
        per_page: Int
    ): Flow<Result<SearchResponse>> {
        return repository.searchUser(username, page, per_page)
    }
}