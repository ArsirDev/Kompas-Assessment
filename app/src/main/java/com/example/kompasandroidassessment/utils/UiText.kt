package com.example.kompasandroidassessment.utils

import android.content.Context
import androidx.annotation.StringRes
import com.example.kompasandroidassessment.R

sealed class UiText {
    data class StringResource(@StringRes val resId: Int): UiText()
    data class DynamicString(val value: String, val type: String? = null): UiText()

    companion object {
        fun unknownError() = StringResource(R.string.ui_text_unknown_error)
    }
}

fun UiText.asString(context: Context): String {
    return when(this) {
        is UiText.DynamicString -> this.value
        is UiText.StringResource -> context.getString(this.resId)
    }
}