package com.example.kompasandroidassessment.feature.presentation.detail.state

import com.example.kompasandroidassessment.feature.data.remote.dto.DetailResponse
import com.example.kompasandroidassessment.feature.data.remote.dto.RepoResponseItem

data class DetailState(
    val isLoading: Boolean = false,
    val detailItem: DetailResponse? = null,
    val detailRepoItem: List<RepoResponseItem> = emptyList()
)