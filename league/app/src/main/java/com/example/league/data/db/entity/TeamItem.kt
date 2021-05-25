package com.example.league.data.db.entity

import android.os.Parcelable
import androidx.recyclerview.widget.DiffUtil
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize


@Entity(
    tableName = "TeamItem",
    foreignKeys = [
        ForeignKey(
            entity = LeagueItem::class,
            parentColumns = ["id"],
            childColumns = ["league_id_in_team"]
        )
    ]
)
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
) : Parcelable {
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null

    @ColumnInfo(name = "league_id_in_team")
    var leagueId: Int? = null

}
