package com.example.league.other

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.league.data.db.entity.TeamItem
import com.example.league.databinding.ItemTeamForAddingBinding
import com.example.league.other.AddingTeamsAdapter.TeamsViewHolder

class AddingTeamsAdapter(
    var teams: List<TeamItem>
) : RecyclerView.Adapter<TeamsViewHolder>() {

    inner class TeamsViewHolder(
        private var binding: ItemTeamForAddingBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        private var listTeams: MutableList<TeamItem> = mutableListOf()


        fun bind(teamItem: TeamItem) {
            binding.radioButtonItem.text = teamItem.name
        }

        constructor(
            parent: ViewGroup
        ) : this(
            ItemTeamForAddingBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

        init {

            binding.radioButtonItem.setOnClickListener {
                var index = 0
                for (i in 0..teams.size step 1) {
                    if (teams[i].name == binding.radioButtonItem.text) {
                        index = i
                        break
                    }
                }
                if (binding.radioButtonItem.isChecked) {
                    listTeams.add(teams[index])
                } else {
                    listTeams.remove(teams[index])
                }
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamsViewHolder {
        return TeamsViewHolder(parent)
    }

    override fun onBindViewHolder(holder: TeamsViewHolder, position: Int) {
        val curItem = teams[position]
        holder.bind(curItem)
    }

    override fun getItemCount(): Int {
        return teams.size
    }
}