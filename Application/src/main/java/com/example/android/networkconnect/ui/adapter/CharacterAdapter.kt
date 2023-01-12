package com.example.android.networkconnect.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android.networkconnect.R
import com.example.android.networkconnect.data.model.Character
import com.example.android.networkconnect.ui.adapter.item.CharacterViewHolder

class CharacterAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var list: MutableList<Character> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_character, parent, false)
        return CharacterViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is CharacterViewHolder -> {
                holder.updateView(list[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun setData(dataList: List<Character>) {
        if (dataList != this.list) {
            this.list = dataList as MutableList<Character>
            notifyDataSetChanged()
        }
    }
}