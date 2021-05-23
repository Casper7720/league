package com.example.league.data.db.entity

import android.os.Parcelable
import androidx.recyclerview.widget.DiffUtil
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "TeamItem")
@Parcelize
data class TeamItem(
    @ColumnInfo(name = "TeamName")
    var name: String,

    @ColumnInfo(name = "WinGames")
    var winGames: Int = 0,

    @ColumnInfo(name = "LooseGames")
    var looseGames: Int = 0,

    @ColumnInfo(name = "DrawGames")
    var drawGames: Int = 0,

    @ColumnInfo(name = "GoalWin")
    var goalsWin: Int = 0,

    @ColumnInfo(name = "GoalLoose")
    var goalsLoose: Int = 0
) : Parcelable{
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null

}
