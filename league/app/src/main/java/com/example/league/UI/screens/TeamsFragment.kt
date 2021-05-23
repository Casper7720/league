package com.example.league.UI.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.league.UI.AppViewModelFactory
import com.example.league.UI.ViewModelPresenter
import com.example.league.UI.dialogs.CreateTeamFragment
import com.example.league.databinding.FragmentTeamsBinding
import com.example.league.other.AppApplication
import com.example.league.other.TeamAdapter


class TeamsFragment : Fragment() {

    private lateinit var binding: FragmentTeamsBinding
    private val viewModel: ViewModelPresenter by viewModels {
        AppViewModelFactory((activity?.application as AppApplication).repository)
    }
    private lateinit var adapter: TeamAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTeamsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = TeamAdapter(listOf())
        binding.teamsRecycler.layoutManager = LinearLayoutManager(requireContext())
        binding.teamsRecycler.adapter = adapter

        viewModel.getAllTeams().observe(requireActivity()){it->
            adapter.teams = it
            adapter.notifyDataSetChanged()
        }


        binding.addTeam.setOnClickListener {
            CreateTeamFragment().show(childFragmentManager, "CreateTeamFragment")
        }
    }


}