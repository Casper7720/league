package com.example.league.UI


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import com.example.league.data.db.entity.LeagueItem
import com.example.league.data.db.entity.TeamItem
import com.example.league.databinding.CreateLeagueBinding
import com.example.league.other.picked

class CreateLeagueFragment : DialogFragment() {
    private var _binding: CreateLeagueBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: ViewModelPresenter
    private lateinit var listId: MutableList<Int>
    private var listTeams: List<TeamItem> = listOf()


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
        listId = mutableListOf()


        picked.teams?.observe(this) {
            listTeams = it
        }


        binding.buttonCreateLeague.setOnClickListener {
            if (binding.editLeagueName.text.isNotEmpty() && listTeams.isNotEmpty()) {
                for (i in listTeams) {
                    listId.add(i.id!!)
                }
                picked.teams?.postValue(listOf())
                val name = binding.editLeagueName.text.toString()
                val league = LeagueItem(name, listId)
                viewModel.insert(league)
                dismiss()
            } else {
                if (binding.editLeagueName.text.isEmpty()) {
                    Toast.makeText(
                        context,
                        "Необходимо ввести текст турнира",
                        Toast.LENGTH_SHORT
                    ).show()
                    return@setOnClickListener
                } else if (listTeams.isEmpty()) {
                    Toast.makeText(
                        context,
                        "Необходимо добавить команды",
                        Toast.LENGTH_SHORT
                    ).show()
                    return@setOnClickListener
                }

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