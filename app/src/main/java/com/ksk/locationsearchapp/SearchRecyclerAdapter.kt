package com.ksk.locationsearchapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ExpandableListView
import androidx.recyclerview.widget.RecyclerView
import com.ksk.locationsearchapp.databinding.ViewholderSearchResultItemBinding

class SearchRecyclerAdapter(
    private var searchResultClickListener: (Any) -> Unit
): RecyclerView.Adapter<SearchRecyclerAdapter.SearchResultItemViewHolder>() {

    private var searchResultList: List<Any> = listOf()

    class SearchResultItemViewHolder(val binding: ViewholderSearchResultItemBinding, val searchResultClickListener: (Any) -> Unit) : RecyclerView.ViewHolder(binding.root) {

        fun bindData(data: Any) = with(binding){
            textextView.text = "제목"
            subtexTexttView.text = "부제목"
       }

        fun bindViews(data: Any) {
            binding.root.setOnClickListener {
                searchResultClickListener(data)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchResultItemViewHolder {
        val view = ViewholderSearchResultItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SearchResultItemViewHolder(view, searchResultClickListener)
    }

    override fun onBindViewHolder(holder: SearchResultItemViewHolder, position: Int) {
        holder.bindData(Any())
        holder.bindViews(Any())
    }

    override fun getItemCount(): Int = 10
}