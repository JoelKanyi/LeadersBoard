package com.kanyideveloper.gadsleaderboard.retrofit

import com.kanyideveloper.gadsleaderboard.models.Learners
import com.kanyideveloper.gadsleaderboard.models.SkillIQ
import retrofit2.Call
import retrofit2.http.GET

const val BASE_URL = "https://gadsapi.herokuapp.com/"

interface RestAPI {

    @GET("api/hours")
    fun getTopLearningLeaders(): Call<List<Learners>>

    @GET("api/skilliq")
    fun getTopSkill(): Call<List<SkillIQ>>
}