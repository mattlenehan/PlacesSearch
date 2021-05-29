package com.example.placessearch

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.placessearch.data.SearchResult
import kotlinx.android.synthetic.main.search_item_view.view.*

class SearchAdapter: RecyclerView.Adapter<SearchAdapter.SearchResultViewHolder>() {

    val list = mutableListOf<SearchResult>()

    fun addItems(items: List<SearchResult>) {
        list.clear()
        list.addAll(items)

        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SearchAdapter.SearchResultViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.search_item_view, parent, false)
        return SearchResultViewHolder(view)
    }

    override fun onBindViewHolder(holder: SearchAdapter.SearchResultViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

    class SearchResultViewHolder(view: View): RecyclerView.ViewHolder(view) {
        fun bind(result: SearchResult) {
            itemView.description.text = result.description
        }
    }
}