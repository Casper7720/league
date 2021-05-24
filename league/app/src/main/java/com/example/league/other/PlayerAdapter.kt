package com.example.league.other

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.league.data.db.entity.PlayerItem
import com.example.league.data.db.entity.TeamItem
import com.example.league.databinding.PlayerItemBinding
import com.example.league.databinding.TeamItemBinding

class PlayerAdapter(
    var players: List<PlayerItem>
) : RecyclerView.Adapter<PlayerAdapter.PlayerViewHolder>() {

    inner class PlayerViewHolder(
        private var binding: PlayerItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {


        fun bind(playerItem: PlayerItem) {
            binding.playerName.text = playerItem.name
        }

        constructor(
            parent: ViewGroup
        ) : this(
            PlayerItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerViewHolder {
        return PlayerViewHolder(parent)
    }

    override fun onBindViewHolder(holder: PlayerViewHolder, position: Int) {
        val curItem = players[position]
        holder.bind(curItem)
    }

    override fun getItemCount(): Int {
        return players.size
    }
}