package com.example.league.data.db

import android.content.Context
import androidx.room.*
import com.example.league.data.db.dao.Dao
import com.example.league.data.db.dao.PlayerDao
import com.example.league.data.db.dao.TeamDao
import com.example.league.data.db.entity.LeagueItem
import com.example.league.data.db.entity.PlayerItem
import com.example.league.data.db.entity.TeamItem

@Database(
    entities = [LeagueItem::class, TeamItem::class, PlayerItem::class],
    version = 7
)
@TypeConverters(TeamConverter::class)
abstract class DataBase : RoomDatabase() {

    abstract fun getDao(): Dao
    abstract fun getTeamDao(): TeamDao
    abstract fun getPlayerDao(): PlayerDao

    companion object {
        @Volatile
        private var instance: DataBase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: createDataBase(context).also { instance = it }
        }

        fun createDataBase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                DataBase::class.java,
                "LeagueDB.db",
            )
                .fallbackToDestructiveMigration()
                .build()
    }
}