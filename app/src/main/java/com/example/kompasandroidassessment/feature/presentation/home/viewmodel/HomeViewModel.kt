package com.example.kompasandroidassessment.feature.presentation.home.viewmodel

import Error.MESSAGE_ERROR
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kompasandroidassessment.core.utils.UiEvent
import com.example.kompasandroidassessment.feature.domain.usecase.GithubUseCase
import com.example.kompasandroidassessment.feature.presentation.home.event.HomeEvent
import com.example.kompasandroidassessment.feature.presentation.home.state.HomeState
import com.example.kompasandroidassessment.utils.Result
import com.example.kompasandroidassessment.utils.UiText
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.plus
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val githubUseCase: GithubUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(HomeState())
    val state: StateFlow<HomeState> = _state

    private val _uiEvent = MutableSharedFlow<UiEvent>()
    val uiEvent = _uiEvent.asSharedFlow()

    fun onEvent(event: HomeEvent) {
        when (event) {
            is HomeEvent.SearchUser -> {
                getSearch(event.query, state.value.page)
            }
            HomeEvent.LoadMore -> {
                if (state.value.allowLoadNext) {
                    getSearch(state.value.searchQuery, state.value.page + 1)
                }
            }
            HomeEvent.SearchRefresh -> {
                getSearch(state.value.searchQuery, state.value.defaultPage)
            }
        }
    }

    private fun getSearch(search: String = "", page: Int = 1, per_page: Int = 30) {
        githubUseCase.getHomeUseCase(search, page, per_page).onEach { result ->
            when (result) {
                is Result.Loading -> {
                    _state.value = state.value.copy(
                        isLoading = true
                    )
                }
                is Result.Success -> {
                    delay(1000)
                    val allow = page < per_page
                    _state.value = state.value.copy(
                        isLoading = false,
                        allowLoadNext = allow,
                        searchQuery = search,
                        listSearch = if (page == 1) {
                            result.data?.items ?: emptyList()
                        } else {
                            state.value.listSearch + (result.data?.items ?: emptyList())
                        }
                    )
                }
                is Result.Error -> {
                    _state.value = state.value.copy(
                        isLoading = false
                    )
                    result.message?.let { msg ->
                        _uiEvent.emit(
                            UiEvent.ShowSnackbar(
                                UiText.DynamicString(
                                    msg,
                                    MESSAGE_ERROR
                                )
                            )
                        )
                    }
                }
            }
        }.launchIn(viewModelScope + IO)
    }
}