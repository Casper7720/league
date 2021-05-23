package com.example.league.UI

import android.app.Application
import androidx.lifecycle.*
import com.example.league.data.db.DataBase
import com.example.league.data.db.entity.LeagueItem
import com.example.league.data.db.entity.TeamItem
import com.example.league.data.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ViewModelPresenter(private var repository: Repository) : ViewModel(){


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
class AppViewModelFactory(private val repository: Repository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ViewModelPresenter::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return ViewModelPresenter(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
