package com.example.android.networkconnect.ui.episodes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.android.networkconnect.databinding.FragmentEpisodesBinding

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

        val textView: TextView = binding.textDashboard
        episodesViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })

        episodesViewModel.onCreateView()
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}