package com.example.league.UI

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewOutlineProvider
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.league.databinding.RvBinding
import com.example.league.other.AddingTeamsAdapter

class FragmentRV : Fragment() {

    private lateinit var binding: RvBinding
    private lateinit var viewModelPresenter: ViewModelPresenter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModelPresenter = ViewModelProvider(this).get(ViewModelPresenter::class.java)
        binding = RvBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var adapter = AddingTeamsAdapter(listOf())
        binding.rv.layoutManager = LinearLayoutManager(requireActivity())
        binding.rv.adapter = adapter

        viewModelPresenter.getAllTeams().observe(requireActivity()){
            adapter.teams = it
            adapter.notifyDataSetChanged()
        }

    }
}