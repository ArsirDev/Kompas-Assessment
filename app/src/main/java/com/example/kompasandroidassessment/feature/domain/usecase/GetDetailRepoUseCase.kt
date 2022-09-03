package com.example.kompasandroidassessment.feature.domain.usecase

import com.example.kompasandroidassessment.feature.data.remote.dto.RepoResponse
import com.example.kompasandroidassessment.feature.domain.repository.GithubRepository
import com.example.kompasandroidassessment.utils.Result
import kotlinx.coroutines.flow.Flow

class GetDetailRepoUseCase(
    private val repository: GithubRepository
) {

    operator fun invoke(
        username: String
    ): Flow<Result<RepoResponse>> {
        return repository.repoDetail(username)
    }
}