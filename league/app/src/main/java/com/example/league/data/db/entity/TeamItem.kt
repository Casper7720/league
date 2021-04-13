package com.example.league.data.db.entity

import androidx.recyclerview.widget.DiffUtil
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "TeamItem")
data class TeamItem(
    @ColumnInfo(name = "TeamName")
    var name: String
){
    @PrimaryKey(autoGenerate = true)
    var id: Long? = null


}
