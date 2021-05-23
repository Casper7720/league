package com.example.league.other

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.league.data.db.entity.TeamItem

object picked {
    var teams : MutableLiveData<List<TeamItem>>? = MutableLiveData()

    var pickedLeaguePosition: Int? = null

    var openLegue: MutableLiveData<Boolean> = MutableLiveData()

}