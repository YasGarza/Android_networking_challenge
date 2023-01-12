package com.example.android.networkconnect.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android.networkconnect.R
import com.example.android.networkconnect.data.model.Location
import com.example.android.networkconnect.ui.adapter.item.LocationViewHolder

class LocationAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var list: MutableList<Location> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_location, parent, false)
        return LocationViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is LocationViewHolder -> {
                holder.updateView(list[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun setData(dataList: List<Location>) {
        if (dataList != this.list) {
            this.list = dataList as MutableList<Location>
            notifyDataSetChanged()
        }
    }
}