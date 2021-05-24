package com.example.league.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.observe
import com.example.league.R
import com.example.league.UI.screens.LeagueTableFragment
import com.example.league.UI.screens.LeaguesFragment
import com.example.league.UI.screens.TeamsFragment
import com.example.league.databinding.ActivityMainBinding
import com.example.league.other.picked
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        picked.openLegue.observe(this){
            if (it == true){
                var fragmentLeagueTable = LeagueTableFragment()

                supportFragmentManager.beginTransaction().apply {
                    replace(R.id.container, fragmentLeagueTable)
                    commit()
                }

            }

        }

        supportFragmentManager.beginTransaction()
            .replace(R.id.container, LeaguesFragment()).commit()

        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {

            override fun onTabSelected(tab: TabLayout.Tab?) {
                when (tab?.position) {
                    0 -> supportFragmentManager.beginTransaction().apply {
                        replace(R.id.container, LeaguesFragment())
                        commit()
                    }

                    1 -> supportFragmentManager.beginTransaction().apply {
                        replace(R.id.container, TeamsFragment())
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
}

