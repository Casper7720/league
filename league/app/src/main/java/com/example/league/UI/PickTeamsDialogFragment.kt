package com.example.league.UI

import android.content.Context
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.*
import androidx.lifecycle.ViewModelProvider
import com.example.league.R
import com.example.league.databinding.PickTeamsDialogBinding
import com.example.league.other.AddingTeamsAdapter
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

        var fragmentRV: FragmentRV = FragmentRV()
        adapter = AddingTeamsAdapter(listOf())
        childFragmentManager.beginTransaction().apply {
            replace(R.id.container_rv, fragmentRV)
            commit()
        }

        viewModel.getAllTeams().observe(viewLifecycleOwner) {
            adapter.teams = it
            adapter.notifyDataSetChanged()
        }

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        var width = (resources.displayMetrics.widthPixels*0.9).toInt()
        var height = -1
        dialog?.window?.setLayout(width, height)

        }

}