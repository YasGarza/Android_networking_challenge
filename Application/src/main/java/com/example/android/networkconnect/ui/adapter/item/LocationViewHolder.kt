package com.example.android.networkconnect.ui.adapter.item

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.android.networkconnect.R
import com.example.android.networkconnect.data.model.Location
import java.lang.ref.WeakReference

class LocationViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private var view: WeakReference<View> = WeakReference(itemView)
    private var name: TextView? = null
    private var type: TextView? = null
    private var residents: TextView? = null
    private var dimension: TextView? = null

    init {
        findView()
    }

    private fun findView() {
        name = view.get()?.findViewById(R.id.location_name)
        type = view.get()?.findViewById(R.id.location_type)
        residents = view.get()?.findViewById(R.id.location_residents)
        dimension = view.get()?.findViewById(R.id.location_dimension)
    }

    fun updateView(item: Location) {
        name?.text = item.name
        type?.text = item.type
        residents?.text = "No. Residents: ${item.residents.count()}"
        dimension?.text = item.dimension
    }
}