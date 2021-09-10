package com.example.weatherapp.ui.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.R
import com.example.weatherapp.api.ApiClient
import com.example.weatherapp.api.ApiInterface
import com.example.weatherapp.domain.TmpI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import androidx.recyclerview.widget.LinearLayoutManager




class SevenDayFrag: Fragment(){

    lateinit var recyclerView: RecyclerView
    lateinit var recyclerAdapter: SevenDaysAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.seven_day, container, false)
        recyclerView = root.findViewById(R.id.recyclerView)
        return root
    }

    override fun onResume() {
        super.onResume()
        val todayApi = ApiClient.getClient().create(ApiInterface::class.java)
        val today: Call<TmpI> = todayApi.getWeatherForSomeCity(55.45,37.36)


        today.enqueue(object : Callback<TmpI> {
            override fun onResponse(call: Call<TmpI>, response: Response<TmpI>) {
                Log.i("Anna", "onResponse: + $response")
                recyclerAdapter = SevenDaysAdapter(requireContext())
                response.body()?.daily?.let { recyclerAdapter.setList(it) }
                recyclerView.layoutManager = LinearLayoutManager(context)
                recyclerView.adapter = recyclerAdapter

            }

            override fun onFailure(call: Call<TmpI>, t: Throwable) {
                Log.i("Anna", "onFailure: $t")
            }

        })



    }
}