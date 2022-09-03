package com.example.kompasandroidassessment.feature.domain.adapter.detail

import android.annotation.SuppressLint
import androidx.recyclerview.widget.RecyclerView
import com.example.kompasandroidassessment.databinding.ItemDetailLayoutBinding
import com.example.kompasandroidassessment.feature.data.remote.dto.RepoResponseItem
import com.example.kompasandroidassessment.utils.convertTime

class DetailRepoViewHolder(
    private val binding: ItemDetailLayoutBinding
): RecyclerView.ViewHolder(binding.root) {
    @SuppressLint("SetTextI18n")
    fun bind(repoResponseItem: RepoResponseItem) {
        with(binding){
            tvTitle.text = repoResponseItem.name
            tvOverview.text = repoResponseItem.description
            tvWatch.text = repoResponseItem.watchersCount.toString()
            tvUpdate.text = "Update ${convertTime(repoResponseItem.updatedAt)}"
        }
    }
}