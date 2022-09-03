package com.example.kompasandroidassessment.feature.presentation.detail.viewmodel

import Error.MESSAGE_ERROR
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kompasandroidassessment.core.utils.UiEvent
import com.example.kompasandroidassessment.feature.domain.usecase.GithubUseCase
import com.example.kompasandroidassessment.feature.presentation.detail.state.DetailState
import com.example.kompasandroidassessment.utils.Result
import com.example.kompasandroidassessment.utils.UiText
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.plus
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val getGithubUseCase: GithubUseCase
): ViewModel() {

    private val _state = MutableStateFlow(DetailState())

    val state get() = _state.asStateFlow()

    private val _uiEvent = MutableSharedFlow<UiEvent>()

    val uiEvent get() = _uiEvent.asSharedFlow()

    fun getDetailUser(username: String) {
        getGithubUseCase.getDetailUseCase(username).onEach { result ->
            when(result) {
                is Result.Loading -> {
                    _state.value = state.value.copy(
                        isLoading = true
                    )
                }
                is Result.Success -> {
                    _state.value = state.value.copy(
                        isLoading = false,
                        detailItem = result.data
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

    fun getDetailRepo(username: String) {
        getGithubUseCase.getDetailRepoUseCase(username).onEach { result ->
            when(result) {
                is Result.Loading -> {
                    _state.value = state.value.copy(
                        isLoading = true
                    )
                }
                is Result.Success -> {
                    _state.value = state.value.copy(
                        isLoading = false,
                        detailRepoItem = result.data?.repoResponse ?: emptyList()
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