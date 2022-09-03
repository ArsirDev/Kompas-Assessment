package com.example.kompasandroidassessment.feature.presentation.home.state

import com.example.kompasandroidassessment.feature.data.remote.dto.SearchItem

data class HomeState(
    val searchQuery: String = "",
    val listSearch: List<SearchItem> = emptyList(),
    val allowLoadNext: Boolean = false,
    val shouldRefresh: Boolean = false,
    val page: Int = 1,
    val defaultPage: Int = 1,
    val isLoading: Boolean = false
)