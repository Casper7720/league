package com.example.league.UI.screens.mainInformation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.league.R
import com.example.league.UI.AppViewModelFactory
import com.example.league.UI.ViewModelPresenter
import com.example.league.UI.dialogs.CreateDialogPlayer
import com.example.league.databinding.FragmentPlayersBinding
import com.example.league.other.AppApplication
import com.example.league.other.PlayerAdapter


class FragmentPlayers : Fragment() {

    private lateinit var binding: FragmentPlayersBinding
    private lateinit var adapter: PlayerAdapter
    private val viewModel: ViewModelPresenter by viewModels {
        AppViewModelFactory((activity?.application as AppApplication).repository)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentPlayersBinding.inflate(layoutInflater)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = PlayerAdapter(listOf())
        viewModel.getAllPlayers().observe(viewLifecycleOwner){it ->
            adapter.players = it
            adapter.notifyDataSetChanged()
        }

        binding.rvPlayers.layoutManager = LinearLayoutManager(requireContext())
        binding.rvPlayers.adapter = adapter

        binding.addPlayer.setOnClickListener {
            CreateDialogPlayer().show(childFragmentManager, "CreateDialogPlayer")
        }

    }
}