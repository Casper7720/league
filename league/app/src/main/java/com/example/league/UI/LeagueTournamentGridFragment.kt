package com.example.league.UI

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.league.data.Team
import com.example.league.data.db.entity.LeagueItem
import com.example.league.databinding.FragmentLeagueTournamentGridBinding
import com.example.league.other.LeagueTournamentAdapter
import com.example.league.other.picked


class LeagueTournamentGridFragment : Fragment() {

    private lateinit var binding: FragmentLeagueTournamentGridBinding
    private lateinit var viewModel: ViewModelPresenter
    private lateinit var league: LeagueItem
    private lateinit var listTeams: MutableList<Team>
    private lateinit var adapter : LeagueTournamentAdapter


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = activity?.let { ViewModelPresenter(it.application) }!!
        league = viewModel.getAllLeague().value!![picked.pickedLeaguePosition!!]
        listTeams = mutableListOf()
        for (id in league.listTeams){
            for (i in viewModel.getAllTeams().value!!.indices){
                if (viewModel.getAllTeams().value!![i].id == id){
                    listTeams.add(Team(viewModel.getAllTeams().value!![i].name,
                        viewModel.getAllTeams().value!![i].id!!,
                    0,0,0,0,0))
                }
            }
        }
        binding = FragmentLeagueTournamentGridBinding.inflate(layoutInflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = LeagueTournamentAdapter(listTeams)
        binding.recyclerViewTournament.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewTournament.adapter = adapter


    }
}