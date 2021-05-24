package com.example.league.data.db.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize


@Entity(tableName = "PlayerItem")
@Parcelize
data class PlayerItem(

    @ColumnInfo(name = "player_name")
    var name: String,

    @ColumnInfo(name = "image", typeAffinity = ColumnInfo.BLOB)
    var image: ByteArray? = null,

    @PrimaryKey(autoGenerate = true)
    var id : Int? = null

): Parcelable