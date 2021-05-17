package com.example.league.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.league.data.db.entity.LeagueItem
import com.example.league.data.db.entity.TeamItem

@Dao
interface Dao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(leagueItem: LeagueItem)

    @Query("SELECT * FROM LeagueItem")
    fun getAllLeague() : LiveData<List<LeagueItem>>

}