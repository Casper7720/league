package com.example.league.UI

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.league.databinding.PickTeamsDialogBinding
import com.example.league.other.AddingTeamsAdapter
import com.example.league.other.picked
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class PickTeamsDialogFragment : BottomSheetDialogFragment() {

    private lateinit var binding: PickTeamsDialogBinding
    private lateinit var viewModel: ViewModelPresenter
    private lateinit var adapter: AddingTeamsAdapter


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = PickTeamsDialogBinding.inflate(layoutInflater, container, false)
        viewModel = ViewModelProvider(requireActivity()).get(ViewModelPresenter::class.java)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        adapter = AddingTeamsAdapter(listOf())
        viewModel.getAllTeams().observe(viewLifecycleOwner) {
            adapter.teams = it
            adapter.notifyDataSetChanged()
        }
        binding.recyclerViewPickTeams.layoutManager = LinearLayoutManager(context)
        binding.recyclerViewPickTeams.adapter = adapter


        binding.imageButton.setOnClickListener {
            picked.teams?.postValue(adapter.listTeams)
            dismiss()
        }




    }
}