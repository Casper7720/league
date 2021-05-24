package com.example.league.UI.screens.mainInformation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.league.R
import com.example.league.UI.AppViewModelFactory
import com.example.league.UI.ViewModelPresenter
import com.example.league.UI.dialogs.CreateLeagueFragment
import com.example.league.databinding.MenuFragmentBinding
import com.example.league.other.AppApplication
import com.example.league.other.LeagueAdapter
import kotlinx.android.synthetic.main.activity_main.*

class LeaguesFragment : Fragment() {

    private lateinit var adapter: LeagueAdapter
    private lateinit var binding: MenuFragmentBinding
    private val viewModel: ViewModelPresenter by viewModels {
        AppViewModelFactory((activity?.application as AppApplication).repository)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = MenuFragmentBinding.inflate(layoutInflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = LeagueAdapter(listOf())
        viewModel.getAllLeague().observe(viewLifecycleOwner) {it->
            adapter.leaguess = it
            adapter.notifyDataSetChanged()
        }
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.adapter = adapter


        binding.add.setOnClickListener {
            CreateLeagueFragment().show(childFragmentManager, "dialog")
        }



    }

}