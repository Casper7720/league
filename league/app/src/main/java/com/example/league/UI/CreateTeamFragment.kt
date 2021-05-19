package com.example.league.UI

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import com.example.league.data.db.entity.TeamItem
import com.example.league.databinding.CreateTeamBinding

class CreateTeamFragment : DialogFragment() {

    private lateinit var binding: CreateTeamBinding
    private lateinit var viewModel: ViewModelPresenter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = CreateTeamBinding.inflate(layoutInflater, container, false)
        viewModel = ViewModelProvider(requireActivity()).get(ViewModelPresenter::class.java)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonCancel.setOnClickListener {
            dismiss()
        }

        binding.buttonApproved.setOnClickListener {
            if (binding.teamNameEditText.text.isNotEmpty()){
                var teamItem = TeamItem(binding.teamNameEditText.text.toString())
                viewModel.insert(teamItem)
                dismiss()
            }
            else{
                Toast.makeText(context, "Team's name is empty", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        var width = (resources.displayMetrics.widthPixels)
        var height = (resources.displayMetrics.heightPixels * 0.26).toInt()
        dialog?.window?.setLayout(width, height)
    }

}