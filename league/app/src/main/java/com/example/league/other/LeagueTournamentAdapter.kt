package com.example.league.other

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.league.UI.LeagueActivity
import com.example.league.UI.MainActivity
import com.example.league.data.Team
import com.example.league.data.db.entity.LeagueItem
import com.example.league.databinding.GridItemBinding
import com.example.league.databinding.LeagueItemBinding

class LeagueTournamentAdapter(var teams: List<Team>
) : RecyclerView.Adapter<LeagueTournamentAdapter.LeagueTournamentViewHolder>() {


    inner class LeagueTournamentViewHolder(
        private var binding: GridItemBinding
    ) :
        RecyclerView.ViewHolder(binding.root) {


        fun bind(team: Team) {
            binding.nameTeam.text = team.name
            binding.gamesTeam.text = (team.winsGame+team.drawGame+team.looseGame).toString()
            binding.goalsTeamWin.text = team.goalsWin.toString()
            binding.goalsTeamLose.text = team.goalsLoose.toString()
            binding.pointsTeam.text = (team.winsGame*3+team.drawGame).toString()

        }

        constructor(
            parent: ViewGroup
        ) : this(
            GridItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )


    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): LeagueTournamentViewHolder {
        return LeagueTournamentViewHolder(parent)
    }

    override fun onBindViewHolder(holder: LeagueTournamentAdapter.LeagueTournamentViewHolder, position: Int) {
        val curItem = teams[position]
        holder.bind(curItem)
    }

    override fun getItemCount(): Int {
        return teams.size
    }

}