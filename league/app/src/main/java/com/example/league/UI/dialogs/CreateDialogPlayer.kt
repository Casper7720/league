package com.example.league.UI.dialogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import com.example.league.UI.AppViewModelFactory
import com.example.league.UI.ViewModelPresenter
import com.example.league.data.db.entity.LeagueItem
import com.example.league.data.db.entity.PlayerItem
import com.example.league.data.db.entity.TeamItem
import com.example.league.databinding.CreateLeagueBinding
import com.example.league.databinding.DialogPlayerCreateBinding
import com.example.league.other.AppApplication
import com.example.league.other.picked

class CreateDialogPlayer : DialogFragment() {
    private var _binding: DialogPlayerCreateBinding? = null
    private val binding get() = _binding!!
    private val viewModel: ViewModelPresenter by viewModels {
        AppViewModelFactory((activity?.application as AppApplication).repository)
    }


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
        _binding = DialogPlayerCreateBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonApproved.setOnClickListener {
            if (binding.teamNameEditText.text.isNotEmpty()) {

                val name = binding.teamNameEditText.text.toString()
                viewModel.insert(PlayerItem(name))
                dismiss()

            } else {

                Toast.makeText(
                    context,
                    "Необходимо ввести имя игрока",
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener

            }

        }
        binding.buttonCancel.setOnClickListener {
            dismiss()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}