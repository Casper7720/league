package com.example.league.UI

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewOutlineProvider
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.league.R
import com.example.league.databinding.FragmentTeamsBinding
import com.example.league.databinding.TeamItemBinding
import com.example.league.other.TeamAdapter


class TeamsFragment : Fragment() {

    private lateinit var binding: FragmentTeamsBinding
    private lateinit var viewModel: ViewModelPresenter
    private lateinit var adapter: TeamAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTeamsBinding.inflate(layoutInflater, container, false)
        viewModel = ViewModelProvider(requireActivity()).get(ViewModelPresenter::class.java)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = TeamAdapter(listOf())
        binding.teamsRecycler.layoutManager = LinearLayoutManager(requireContext())
        binding.teamsRecycler.adapter = adapter

        viewModel.getAllTeams().observe(requireActivity()){
            adapter.teams = it
            adapter.notifyDataSetChanged()
        }


        binding.addTeam.setOnClickListener {
            CreateTeamFragment().show(childFragmentManager, "CreateTeamFragment")
        }
    }


}