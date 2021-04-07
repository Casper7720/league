package com.example.league.UI

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.league.data.db.DataBase
import com.example.league.data.db.entity.LeagueItem
import com.example.league.data.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ViewModelPresenter(application: Application) : AndroidViewModel(application){

    private var repository: Repository = Repository(DataBase.invoke(application))

    fun insert(leagueItem: LeagueItem) = viewModelScope.launch(Dispatchers.IO){
        repository.insert(leagueItem)
    }

    fun getAllLeague() = repository.getAllLeague()

}
