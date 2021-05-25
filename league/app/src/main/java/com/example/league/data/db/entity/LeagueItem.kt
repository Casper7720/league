package com.example.league.data.db.entity

import androidx.room.*
import com.example.league.data.Game

@Entity(tableName = "LeagueItem")

data class LeagueItem(

    @ColumnInfo(name = "league_title")
    var name: String,

    @Ignore
    @ColumnInfo(name = "player_first")
    var playerFirst : PlayerItem,

    @Ignore
    @ColumnInfo(name = "player_second")
    var playerSecond : PlayerItem,


    @Embedded
    var games : List<Game>,

    @ColumnInfo(name = "list_teams")
    @Ignore
    var listTeams: List<TeamItem>

){
    constructor(): this("","","")
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "league_id")
    var id : Int? = null
}
