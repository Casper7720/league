package com.example.league.data.repository

import androidx.lifecycle.MutableLiveData
import com.example.league.data.db.DataBase
import com.example.league.data.db.entity.LeagueItem


class Repository( private var dataBase : DataBase) {

    suspend fun insert(leagueItem: LeagueItem) = dataBase.getDao().insert(leagueItem)

}