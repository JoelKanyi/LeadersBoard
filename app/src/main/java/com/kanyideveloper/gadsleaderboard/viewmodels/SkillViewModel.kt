package com.kanyideveloper.gadsleaderboard.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.kanyideveloper.gadsleaderboard.models.SkillIQ
import com.kanyideveloper.gadsleaderboard.repository.SkillRepository

class SkillViewModel(application: Application) : AndroidViewModel(application){
     private val skillRepository = SkillRepository(application)
    val showProgress: LiveData<Boolean>
     val topSkillIQLeadersList : LiveData<List<SkillIQ>>

   init {
       this.showProgress = skillRepository.showProgress
       this.topSkillIQLeadersList = skillRepository.skillIQList
   }

    fun getTopSkillIQLeaders(){
        skillRepository.getTopSkill()
    }

}
