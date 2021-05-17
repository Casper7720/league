package com.example.league.data.db

import android.util.Log
import androidx.room.TypeConverter
import com.example.league.data.db.entity.TeamItem
import java.lang.StringBuilder
import java.util.*

class TeamConverter {

    @TypeConverter
    fun fromTeams(list: MutableList<Int>): String{
        var builder: StringBuilder = StringBuilder()
        for (i in list){
            builder.append(i.toString())
            builder.append(",")
        }
        Log.i("string", builder.toString())
        return builder.toString()
    }

    @TypeConverter
    fun toTeams(id: String):List<Int>{
        var list : MutableList<Int> = mutableListOf()
        var idTeam: StringBuilder = StringBuilder()
        for(i in 0..id.length-1){
            if(id[i] == ','){
                list.add(idTeam.toString().toInt())
                idTeam.clear()
                continue
            }
            else{
                idTeam.append(id[i].toString())
            }

        }
        idTeam.clear()
        return list
    }
}