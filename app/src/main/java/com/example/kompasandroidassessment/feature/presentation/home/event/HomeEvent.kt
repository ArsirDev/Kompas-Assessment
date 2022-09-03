package com.example.kompasandroidassessment.feature.presentation.home.event

sealed class HomeEvent {
    data class SearchUser(val query: String = "") : HomeEvent()
    object LoadMore : HomeEvent()
    object SearchRefresh: HomeEvent()
}