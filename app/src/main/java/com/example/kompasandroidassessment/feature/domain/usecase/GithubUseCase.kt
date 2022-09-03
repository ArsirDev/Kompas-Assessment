package com.example.kompasandroidassessment.feature.domain.usecase

data class GithubUseCase(
    val getHomeUseCase: GetHomeUseCase,
    val getDetailUseCase: GetDetailUseCase,
    val getDetailRepoUseCase: GetDetailRepoUseCase
)