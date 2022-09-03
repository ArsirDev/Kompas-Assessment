package com.example.kompasandroidassessment.core.utils

import com.example.kompasandroidassessment.utils.UiText

sealed class UiEvent {
    data class ShowSnackbar(val message: UiText): UiEvent()
}
