package com.example.league.data

data class Team(
    val name: String,
    val id: Int,
    var goalsWin: Int,
    var goalsLoose: Int,
    var winsGame: Int,
    var drawGame: Int,
    var looseGame: Int
)