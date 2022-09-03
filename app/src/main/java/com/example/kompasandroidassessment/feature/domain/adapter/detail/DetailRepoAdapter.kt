package com.example.kompasandroidassessment.feature.domain.adapter.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.kompasandroidassessment.databinding.ItemDetailLayoutBinding
import com.example.kompasandroidassessment.feature.data.remote.dto.RepoResponseItem

class DetailRepoAdapter: RecyclerView.Adapter<DetailRepoViewHolder>() {

    private val differCallBack = object : DiffUtil.ItemCallback<RepoResponseItem>() {
        override fun areItemsTheSame(
            oldItem: RepoResponseItem,
            newItem: RepoResponseItem
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: RepoResponseItem,
            newItem: RepoResponseItem
        ): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallBack)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailRepoViewHolder {
        return DetailRepoViewHolder(ItemDetailLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holderRepo: DetailRepoViewHolder, position: Int) {
        holderRepo.bind(differ.currentList[position])
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    companion object {
        fun instance() = DetailRepoAdapter()
    }

}