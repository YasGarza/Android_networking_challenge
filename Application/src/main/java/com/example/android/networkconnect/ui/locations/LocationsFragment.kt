package com.example.android.networkconnect.ui.locations

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android.networkconnect.databinding.FragmentLocationsBinding
import com.example.android.networkconnect.ui.adapter.LocationAdapter

class LocationsFragment : Fragment() {

    private lateinit var locationsViewModel: LocationsViewModel
    private var _binding: FragmentLocationsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        locationsViewModel =
                ViewModelProvider(this).get(LocationsViewModel::class.java)

        _binding = FragmentLocationsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        locationsViewModel.onCreateView()

        val recyclerview: RecyclerView = binding.locationsRecyclerview
        recyclerview.layoutManager = LinearLayoutManager(this.context)
        val adapter = LocationAdapter()
        recyclerview.adapter = adapter

        locationsViewModel.locations.observe(viewLifecycleOwner, Observer {
            adapter.setData(it)
            binding.charactersProgressbar.visibility = View.GONE
        })

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}