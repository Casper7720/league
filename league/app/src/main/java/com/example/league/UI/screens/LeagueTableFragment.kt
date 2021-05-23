package com.example.league.UI.screens

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.league.R
import com.example.league.UI.AppViewModelFactory
import com.example.league.UI.ViewModelPresenter
import com.example.league.databinding.FragmentLeagueTournamentGridBinding
import com.example.league.other.AppApplication
import com.example.league.other.LeagueTournamentAdapter

class LeagueTableFragment : Fragment() {
    private lateinit var binding: FragmentLeagueTournamentGridBinding
    private lateinit var adapter: LeagueTournamentAdapter
    private val viewModel: ViewModelPresenter by viewModels {
        AppViewModelFactory((activity?.application as AppApplication).repository)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLeagueTournamentGridBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        adapter = LeagueTournamentAdapter(listOf())
        viewModel.getAllTeams().observe(requireActivity()){
            adapter.teams = it
            adapter.notifyDataSetChanged()
        }

        binding.recyclerViewTournament.layoutManager = LinearLayoutManager(requireActivity())
        binding.recyclerViewTournament.adapter = adapter


    }
}