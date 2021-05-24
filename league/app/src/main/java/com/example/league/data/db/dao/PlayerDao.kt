package com.example.league.data.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.league.data.db.entity.LeagueItem
import com.example.league.data.db.entity.PlayerItem

@Dao
interface PlayerDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(playerItem: PlayerItem)

    @Query("SELECT * FROM PlayerItem")
    fun getAllPlayers() : LiveData<List<PlayerItem>>

}