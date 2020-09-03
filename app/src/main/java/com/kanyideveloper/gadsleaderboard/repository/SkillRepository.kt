package com.kanyideveloper.gadsleaderboard.repository

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.kanyideveloper.gadsleaderboard.models.Skiller
import com.kanyideveloper.gadsleaderboard.retrofit.RestAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class SkillRepository (val application: Application){

    val showProgess = MutableLiveData<Boolean>()
    val topSkillersList = MutableLiveData<List<Skiller>>()

    fun getTopSkiller(){
        showProgess.value = true

        //Network call
        val retrofit = Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).build()
        val service = retrofit.create(RestAPI::class.java)
        service.getTopSkiller().enqueue(object : Callback<List<Skiller>>{
            override fun onResponse(call: Call<List<Skiller>>, response: Response<List<Skiller>>) {
                showProgess.value = false
                topSkillersList.value = response.body()

            }

            override fun onFailure(call: Call<List<Skiller>>, t: Throwable) {
                showProgess.value = false
                Toast.makeText(application, "Failed to load data, check your internet connection",
                        Toast.LENGTH_SHORT).show()
            }
        })
    }
}