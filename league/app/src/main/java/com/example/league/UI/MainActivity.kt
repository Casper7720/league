package com.example.league.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.INVISIBLE
import android.view.View.VISIBLE

import androidx.lifecycle.observe
import com.example.league.R
import com.example.league.UI.screens.leaguesInformation.LeagueTableFragment
import com.example.league.UI.screens.mainInformation.FragmentPlayers
import com.example.league.UI.screens.mainInformation.LeaguesFragment
import com.example.league.UI.screens.mainInformation.TeamsFragment
import com.example.league.databinding.ActivityMainBinding
import com.example.league.other.picked
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        picked.openLegue.observe(this) {
            if (it == true) {
                var fragmentLeagueTable = LeagueTableFragment()

                binding.activityTab.visibility = INVISIBLE
                binding.leagueTab.visibility = VISIBLE

                supportFragmentManager.beginTransaction().apply {
                    replace(R.id.container, fragmentLeagueTable)
                    addToBackStack("fragmentLeagueTable")
                    commit()
                }
            }
        }

        supportFragmentManager.beginTransaction()
            .replace(R.id.container, LeaguesFragment()).commit()

        binding.activityTab.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {

            override fun onTabSelected(tab: TabLayout.Tab?) {
                when (tab?.position) {
                    0 -> supportFragmentManager.beginTransaction().apply {
                        replace(
                            R.id.container,
                            LeaguesFragment()
                        )
                        commit()
                    }

                    1 -> supportFragmentManager.beginTransaction().apply {
                        replace(
                            R.id.container,
                            TeamsFragment()
                        )
                        commit()
                    }

                    2 -> supportFragmentManager.beginTransaction().apply {
                        replace(
                            R.id.container,
                            FragmentPlayers()
                        )
                        commit()
                    }
                }
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                // Handle tab reselect
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                // Handle tab unselect
            }
        })

    }

    override fun onBackPressed() {
        super.onBackPressed()
        binding.activityTab.visibility = VISIBLE
        binding.leagueTab.visibility = INVISIBLE
    }
}

