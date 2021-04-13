package com.example.league.UI


import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.league.databinding.MenuFragmentBinding
import com.example.league.other.LeagueAdapter

class LeaguesFragment : Fragment() {


    private lateinit var adapter: LeagueAdapter
    private lateinit var binding: MenuFragmentBinding
    private lateinit var viewModel: ViewModelPresenter



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewModel = ViewModelProvider(requireActivity()).get(ViewModelPresenter::class.java)
        binding = MenuFragmentBinding.inflate(layoutInflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = LeagueAdapter(listOf())
        viewModel.getAllLeague().observe(viewLifecycleOwner) {
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