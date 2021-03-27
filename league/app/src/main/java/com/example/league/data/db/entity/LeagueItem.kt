package com.example.league.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "LeagueItem")
data class LeagueItem(
    @ColumnInfo(name = "league_title")
    val name:String
){

    @PrimaryKey(autoGenerate = true)
    val id : Long? = null
}
