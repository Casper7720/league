package com.example.league.other

import android.app.Application
import com.example.league.data.db.DataBase
import com.example.league.data.repository.Repository

class AppApplication : Application() {
    private val database by lazy { DataBase.createDataBase(this) }
    val repository by lazy { Repository(database) }
}