package com.example.android.networkconnect.ui.characters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.android.networkconnect.databinding.FragmentCharactersBinding
import com.example.android.networkconnect.ui.adapter.CharacterAdapter

class CharactersFragment : Fragment() {

    private lateinit var charactersViewModel: CharactersViewModel
    private var _binding: FragmentCharactersBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        charactersViewModel =
                ViewModelProvider(this).get(CharactersViewModel::class.java)

        _binding = FragmentCharactersBinding.inflate(inflater, container, false)
        val root: View = binding.root

        charactersViewModel.onCreateView()

        val recyclerview: RecyclerView = binding.charactersRecyclerview
        recyclerview.layoutManager = LinearLayoutManager(this.context)
        val adapter = CharacterAdapter()
        recyclerview.adapter = adapter

        charactersViewModel.characters.observe(viewLifecycleOwner, Observer {
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