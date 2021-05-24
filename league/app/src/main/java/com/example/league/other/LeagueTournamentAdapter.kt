package com.example.league.other

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.league.data.db.entity.TeamItem
import com.example.league.databinding.GridItemBinding

class LeagueTournamentAdapter(var teams: List<TeamItem>
) : RecyclerView.Adapter<LeagueTournamentAdapter.LeagueTournamentViewHolder>() {


    inner class LeagueTournamentViewHolder(
        private var binding: GridItemBinding
    ) :
        RecyclerView.ViewHolder(binding.root) {


        fun bind(team: TeamItem) {
            binding.nameTeam.text = team.name
            binding.gamesTeam.text = (team.winGames+team.drawGames+team.looseGames).toString()
            binding.goalsTeamWin.text = team.goalsWin.toString()
            binding.goalsTeamLose.text = team.goalsLoose.toString()
            binding.pointsTeam.text = (team.winGames*3+team.drawGames).toString()

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