package com.example.android.networkconnect.ui.adapter.item

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android.networkconnect.R
import com.example.android.networkconnect.data.model.Episode

class EpisodeAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var list: MutableList<Episode> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_episode, parent, false)
        return EpisodeViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is EpisodeViewHolder -> {
                holder.updateView(list[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun setData(dataList: List<Episode>) {
        if (dataList != this.list) {
            this.list = dataList as MutableList<Episode>
            notifyDataSetChanged()
        }
    }
}