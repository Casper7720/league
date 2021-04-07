package com.example.league.other


import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.league.UI.ViewModelPresenter
import com.example.league.data.db.entity.LeagueItem
import com.example.league.databinding.LeagueItemBinding

class LeagueAdapter(
    var leaguess: List<LeagueItem>
) : RecyclerView.Adapter<LeagueAdapter.LeagueViewHolder>() {


    inner class LeagueViewHolder(
        private var binding: LeagueItemBinding) :
        RecyclerView.ViewHolder(binding.root) {


        fun bind(leagueItem: LeagueItem) {
            binding.textView.text = leagueItem.name
        }

        constructor(
            parent: ViewGroup
        ) : this(
            LeagueItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

//        init {
//
//        }
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): LeagueViewHolder {
        return LeagueViewHolder(parent)
    }

    override fun onBindViewHolder(holder: LeagueAdapter.LeagueViewHolder, position: Int) {
        val curItem = leaguess[position]
        holder.bind(curItem)
    }

    override fun getItemCount(): Int {
        return leaguess.size
    }

}