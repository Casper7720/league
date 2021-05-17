package com.example.league.other

import androidx.lifecycle.MutableLiveData
import com.example.league.data.db.entity.TeamItem

object picked {
    var teams : MutableLiveData<List<TeamItem>>? = MutableLiveData()

    var pickedLeaguePosition: Int? = null

}