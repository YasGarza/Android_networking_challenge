package com.example.android.networkconnect.ui.episodes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android.networkconnect.databinding.FragmentEpisodesBinding
import com.example.android.networkconnect.ui.adapter.item.EpisodeAdapter

class EpisodesFragment : Fragment() {

    private lateinit var episodesViewModel: EpisodesViewModel
    private var _binding: FragmentEpisodesBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        episodesViewModel =
                ViewModelProvider(this).get(EpisodesViewModel::class.java)

        _binding = FragmentEpisodesBinding.inflate(inflater, container, false)
        val root: View = binding.root

        episodesViewModel.onCreateView()

        val recyclerview: RecyclerView = binding.episodesRecyclerview
        recyclerview.layoutManager = LinearLayoutManager(this.context)
        val adapter = EpisodeAdapter()
        recyclerview.adapter = adapter

        episodesViewModel.episodes.observe(viewLifecycleOwner, Observer {
            adapter.setData(it)
        })

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}