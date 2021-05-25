package com.example.league.data


data class Game(
    var playerOne: String,

    var playerTwo: String,

    var teamOne: String,

    var teamTwo: String,

    var howGoalsMakeTeamOne : Int?,

    var howGoalsMakeTeamSecond : Int?
)