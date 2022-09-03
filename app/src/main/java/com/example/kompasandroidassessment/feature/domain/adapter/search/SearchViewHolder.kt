package com.example.kompasandroidassessment.feature.domain.adapter.search

import androidx.recyclerview.widget.RecyclerView
import com.example.kompasandroidassessment.databinding.ListUseItemLayoutBinding
import com.example.kompasandroidassessment.feature.data.remote.dto.SearchItem
import com.example.kompasandroidassessment.utils.loadImage

class SearchViewHolder(
    private val binding: ListUseItemLayoutBinding
): RecyclerView.ViewHolder(binding.root) {
    fun bind(searchItem: SearchItem) {
        binding.ivAvatar.loadImage(searchItem.avatarUrl ?: "")
        binding.tvUsername.text = searchItem.login
    }
}