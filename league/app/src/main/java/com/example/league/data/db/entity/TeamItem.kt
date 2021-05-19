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
    var name: String
) : Parcelable{
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null

}
