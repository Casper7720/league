package com.example.league.UI


import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import com.example.league.R
import com.example.league.data.db.entity.LeagueItem
import com.example.league.databinding.CreateLeagueBinding

class CreateLeagueFragment : DialogFragment() {
    private var _binding: CreateLeagueBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: ViewModelPresenter




    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        var width = (resources.displayMetrics.widthPixels)
        var height = (resources.displayMetrics.heightPixels * 0.36).toInt()
        dialog?.window?.setLayout(width, height)
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = CreateLeagueBinding.inflate(layoutInflater, container, false)
        viewModel = ViewModelProvider(requireActivity()).get(ViewModelPresenter::class.java)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonAddTeamsToLeague.setOnClickListener {
            PickTeamsDialogFragment().show(childFragmentManager, "PickTeamsDialogFragment")
        }

        binding.buttonCreateLeague.setOnClickListener {
            if (binding.editLeagueName.text.isNotEmpty()) {
                val name = binding.editLeagueName.text.toString()
                val league = LeagueItem(name)
                viewModel.insert(league)
                dismiss()
            } else {
                Toast.makeText(
                    context,
                    "Необходимо ввести текст турнира",
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }

        }
        binding.buttonCancelToMenu.setOnClickListener {
            dismiss()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}