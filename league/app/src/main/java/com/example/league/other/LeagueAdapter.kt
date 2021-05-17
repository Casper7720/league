package com.example.league.other


import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.league.UI.LeagueActivity
import com.example.league.UI.MainActivity
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

        init {
            binding.root.setOnClickListener {
                picked.pickedLeaguePosition = adapterPosition
                val activity = itemView.context as? MainActivity
                val intent: Intent = Intent(activity, LeagueActivity::class.java)
                activity?.startActivity(intent)
            }
        }
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