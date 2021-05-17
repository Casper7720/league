package com.example.league.data.db.entity

import androidx.room.*

@Entity(tableName = "LeagueItem")

data class LeagueItem(

    @ColumnInfo(name = "league_title")
    var name: String,

    @ColumnInfo(name = "list_teams")
    var listTeams: MutableList<Int>

){

    @PrimaryKey(autoGenerate = true)
    var id : Int? = null
}
