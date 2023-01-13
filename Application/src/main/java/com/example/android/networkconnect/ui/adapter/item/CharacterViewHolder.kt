package com.example.android.networkconnect.ui.adapter.item

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.android.networkconnect.R
import com.example.android.networkconnect.data.model.Character
import java.lang.ref.WeakReference

class CharacterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private var view: WeakReference<View> = WeakReference(itemView)
    private var image: ImageView? = null
    private var name: TextView? = null
    private var species: TextView? = null
    private var gender: TextView? = null
    private var origin: TextView? = null

    init {
        findView()
    }

    private fun findView() {
        image = view.get()?.findViewById(R.id.character_image)
        name = view.get()?.findViewById(R.id.character_name)
        species = view.get()?.findViewById(R.id.character_species)
        gender = view.get()?.findViewById(R.id.character_gender)
        origin = view.get()?.findViewById(R.id.character_origin)
    }

    fun updateView(item: Character) {
        name?.text = item.name
        species?.text = item.species
        gender?.text = item.gender
        origin?.text = item.origin.name

        image?.let {
            Glide
                .with(itemView.context)
                .load(item.image)
                .into(it)
        }
    }
}