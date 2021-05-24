package com.example.league.data.repository

import androidx.lifecycle.LiveData
import com.example.league.data.db.DataBase
import com.example.league.data.db.entity.LeagueItem
import com.example.league.data.db.entity.PlayerItem
import com.example.league.data.db.entity.TeamItem


class Repository( private var dataBase: DataBase) {

    suspend fun insert(leagueItem: LeagueItem) = dataBase.getDao().insert(leagueItem)

    fun getAllLeague(): LiveData<List<LeagueItem>> = dataBase.getDao().getAllLeague()

    suspend fun insert(teamItem: TeamItem) = dataBase.getTeamDao().insert(teamItem)

    fun getAllTeams(): LiveData<List<TeamItem>> = dataBase.getTeamDao().getAllTeams()

    suspend fun insert(playerItem: PlayerItem) = dataBase.getPlayerDao().insert(playerItem)

    fun getAllPlayers(): LiveData<List<PlayerItem>> = dataBase.getPlayerDao().getAllPlayers()

}