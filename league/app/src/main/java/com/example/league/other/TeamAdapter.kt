package com.example.league.other

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.league.data.db.entity.TeamItem
import com.example.league.databinding.TeamItemBinding

class TeamAdapter(
    var teams: List<TeamItem>
) : RecyclerView.Adapter<TeamAdapter.TeamViewHolder>() {

    inner class TeamViewHolder(
        private var binding: TeamItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {


        fun bind(teamItem: TeamItem) {
            binding.teamTitle.text = teamItem.name
        }

        constructor(
            parent: ViewGroup
        ) : this(
            TeamItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

//        init {
//
//        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TeamViewHolder {
        return TeamViewHolder(parent)
    }

    override fun onBindViewHolder(holder: TeamViewHolder, position: Int) {
        val curItem = teams[position]
        holder.bind(curItem)
    }

    override fun getItemCount(): Int {
        return teams.size
    }
}