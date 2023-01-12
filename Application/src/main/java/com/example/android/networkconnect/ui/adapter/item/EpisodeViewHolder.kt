package com.example.android.networkconnect.ui.adapter.item

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.android.networkconnect.R
import com.example.android.networkconnect.data.model.Episode
import java.lang.ref.WeakReference

class EpisodeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private var view: WeakReference<View> = WeakReference(itemView)
    private var name: TextView? = null
    private var code: TextView? = null
    private var airTime: TextView? = null
    private var characters: TextView? = null

    init {
        findView()
    }

    private fun findView() {
        name = view.get()?.findViewById(R.id.episode_name)
        code = view.get()?.findViewById(R.id.episode_code)
        airTime = view.get()?.findViewById(R.id.episode_air_time)
        characters = view.get()?.findViewById(R.id.episode_characters)
    }

    fun updateView(item: Episode) {
        name?.text = item.name
        code?.text = item.episode
        airTime?.text = item.airTime
        characters?.text = "No. Characters: ${item.characters.count()}"
    }
}