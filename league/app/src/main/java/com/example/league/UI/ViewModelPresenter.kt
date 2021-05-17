package com.example.league.UI

import android.app.Application
import androidx.lifecycle.*
import com.example.league.data.db.DataBase
import com.example.league.data.db.entity.LeagueItem
import com.example.league.data.db.entity.TeamItem
import com.example.league.data.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ViewModelPresenter(application: Application) : AndroidViewModel(application){

    private var repository: Repository = Repository(DataBase.invoke(application))

    private val mutableListTeams = MutableLiveData<List<TeamItem>>()
    val listTeams : LiveData<List<TeamItem>> get() = mutableListTeams

    fun addTeams(list: List<TeamItem>){
        mutableListTeams.value = list
    }

    fun insert(leagueItem: LeagueItem) = viewModelScope.launch(Dispatchers.IO){
        repository.insert(leagueItem)
    }

    fun getAllLeague() = repository.getAllLeague()

    fun insert(teamItem: TeamItem) = viewModelScope.launch(Dispatchers.IO){
        repository.insert(teamItem)
    }

    fun getAllTeams() = repository.getAllTeams()

}
