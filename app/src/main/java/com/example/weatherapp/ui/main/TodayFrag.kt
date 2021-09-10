package com.example.weatherapp.ui.main



import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.weatherapp.R
import com.example.weatherapp.api.ApiInterface

import com.example.weatherapp.api.ApiClient.getClient
import com.example.weatherapp.domain.TmpI
import retrofit2.Call
import android.util.Log

import retrofit2.Callback
import retrofit2.Response


class TodayFrag: Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.today, container, false)
        return root
    }

    override fun onResume() {
        super.onResume()
        val todyApi = getClient().create(ApiInterface::class.java)
        val today: Call<TmpI> = todyApi.getWeatherForSomeCity(55.45,37.36)

        today.enqueue(object : Callback<TmpI> {
            override fun onResponse(call: Call<TmpI>, response: Response<TmpI>) {
                Log.i("Anna", "onResponse: + $response")
                Log.i("Anna", "onResponseBody: + ${response.body()}")


            }

            override fun onFailure(call: Call<TmpI>, t: Throwable) {
                Log.i("Anna", "onFailure: $t")
            }

        })



    }

}