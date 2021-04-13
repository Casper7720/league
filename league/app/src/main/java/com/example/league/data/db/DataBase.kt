package com.example.league.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.league.data.db.entity.LeagueItem
import com.example.league.data.db.entity.TeamItem

@Database(
    entities = [LeagueItem::class, TeamItem::class],
    version = 2
)

abstract class DataBase : RoomDatabase() {

    abstract fun getDao(): Dao
    abstract fun getTeamDao(): TeamDao

    companion object {
        @Volatile
        private var instance: DataBase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: createDataBase(context).also { instance = it }
        }

        private fun createDataBase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                DataBase::class.java,
                "LeagueDB.db",
            )
                .fallbackToDestructiveMigration()
                .build()
    }
}