package com.example.kompasandroidassessment.utils

import Error.MESSAGE_ERROR
import Error.MESSAGE_SUCCESS
import android.view.View
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kompasandroidassessment.R
import com.google.android.material.snackbar.Snackbar
import com.google.gson.Gson
import com.google.gson.JsonIOException
import com.google.gson.JsonSyntaxException
import java.io.Reader
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit

inline fun<reified T> Reader.fromJson(): T? {
    return try {
        Gson().fromJson(this, T::class.java)
    } catch (e: JsonSyntaxException){
        null
    } catch (e: JsonIOException) {
        null
    }
}

fun ImageView.loadImage(imageUrl: String) {
    Glide.with(this.context)
        .load(imageUrl)
        .error(ContextCompat.getDrawable(this.context, R.drawable.ic_broken_image_black))
        .placeholder(ContextCompat.getDrawable(this.context, R.drawable.ic_image_black))
        .into(this)
}

fun View.showView() {
    this.visibility = View.VISIBLE
}

fun View.removeView() {
    this.visibility = View.GONE
}

fun String.onValidation(): Boolean {
    return when {
        this.isEmpty() -> {
            false
        }
        else -> true
    }
}

fun convertTime(date: String): String {
    try {
        val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
        val past = inputFormat.parse(date)
        val now = Date()
        val seconds: Long =
            TimeUnit.MILLISECONDS.toSeconds(now.time - past.time)
        val minutes: Long =
            TimeUnit.MILLISECONDS.toMinutes(now.time - past.time)
        val hours: Long = TimeUnit.MILLISECONDS.toHours(now.time - past.time)
        val days: Long = TimeUnit.MILLISECONDS.toDays(now.time - past.time)

        return when {
            seconds < 60 -> {
                "$seconds seconds ago"
            }
            minutes < 60 -> {
                "$minutes minutes ago"
            }
            hours < 24 -> {
                "$hours hours ago"
            }
            else -> {
                "$days days ago"
            }
        }
    } catch (j: Exception) {
        j.printStackTrace()
        return date
    }
}

fun snackbar(view: View, type: String?, message: String, duration: Int = Snackbar.LENGTH_LONG) {
    if (type == MESSAGE_SUCCESS) {
        val snack = Snackbar.make(view, message, duration)
        snack.view.setBackgroundColor(ContextCompat.getColor(view.context, R.color.colorGreen))
        snack.show()
    } else if (type == MESSAGE_ERROR) {
        val snack = Snackbar.make(view, message, duration)
        snack.view.setBackgroundColor(ContextCompat.getColor(view.context, R.color.colorTextColorRed))
        snack.show()
    }
}

fun isLastVisible(rv: RecyclerView, shouldFindLastCompletelyVisible: Boolean = true): Boolean {
    val layoutManager = rv.layoutManager as LinearLayoutManager
    val pos = if (shouldFindLastCompletelyVisible) {
        layoutManager.findLastCompletelyVisibleItemPosition()
    } else {
        layoutManager.findFirstVisibleItemPosition()
    }
    val numItems: Int = rv.adapter?.itemCount ?: 0
    return pos >= numItems - 1
}