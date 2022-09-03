package com.example.kompasandroidassessment.feature.domain.adapter.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.kompasandroidassessment.databinding.ListUseItemLayoutBinding
import com.example.kompasandroidassessment.feature.data.remote.dto.SearchItem

class SearchAdapter: RecyclerView.Adapter<SearchViewHolder>() {

    private val differCallBack = object : DiffUtil.ItemCallback<SearchItem>(){
        override fun areItemsTheSame(oldItem: SearchItem, newItem: SearchItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: SearchItem, newItem: SearchItem): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallBack)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        return SearchViewHolder(ListUseItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        holder.apply {
            bind(differ.currentList[position].also { item ->
                itemView.setOnClickListener {
                    onItemClickListener?.let { dataItem ->
                        dataItem(item.login.toString())
                    }
                }
            })
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    private var onItemClickListener: ((String) -> Unit)? = null

    fun setOnItemClickListener(listener: (String) -> Unit) {
        onItemClickListener = listener
    }

    companion object {
        fun instance() = SearchAdapter()
    }
}