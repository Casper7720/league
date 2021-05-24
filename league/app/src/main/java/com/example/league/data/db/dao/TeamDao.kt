package com.example.league.data.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.league.data.db.entity.TeamItem

@Dao
interface TeamDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(teamItem: TeamItem)

    @Query("SELECT * FROM TeamItem")
    fun getAllTeams(): LiveData<List<TeamItem>>
}