package com.example.weatherapp.ui.main.todayfrog


import android.annotation.SuppressLint
import android.os.Build
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
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import com.bumptech.glide.Glide
import com.example.weatherapp.MainActivity
import com.example.weatherapp.data.Coordinates
import com.example.weatherapp.data.Coordinates.Companion.Moscow

import retrofit2.Callback
import retrofit2.Response


class TodayFrag : Fragment() {

    lateinit var city: TextView
    private lateinit var temp: TextView
    private lateinit var feelsLike: TextView
    lateinit var humidity: TextView
    lateinit var pressure: TextView
    lateinit var main: TextView
    lateinit var description: TextView
    lateinit var weatherIcon: ImageView


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.today, container, false)
        city = root.findViewById(R.id.City)
        temp = root.findViewById(R.id.temp)
        feelsLike = root.findViewById(R.id.feels_like)
        humidity = root.findViewById(R.id.humidity)
        pressure = root.findViewById(R.id.pressure)
        main = root.findViewById(R.id.main)
        description = root.findViewById(R.id.description)
        weatherIcon = root.findViewById(R.id.weatherIcon)


        return root
    }

    override fun onResume() {
        super.onResume()
        val todayApi = getClient().create(ApiInterface::class.java)
        val coordinates: Coordinates = (activity as MainActivity).getCoordinates() ?: Moscow

        val today: Call<TmpI> = todayApi.getWeatherForSomeCity(coordinates.lat, coordinates.lon)

        today.enqueue(object : Callback<TmpI> {
            @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
            @SuppressLint("UseCompatLoadingForDrawables")
            override fun onResponse(call: Call<TmpI>, response: Response<TmpI>) {
                city.text = response.body()?.timezone ?: ""
                temp.text = response.body()?.current?.temp.toString()
                feelsLike.text = response.body()?.current?.feels_like.toString()
                humidity.text = response.body()?.current?.humidity.toString()
                pressure.text = response.body()?.current?.pressure.toString()
                main.text = response.body()?.current?.weatherBody?.get(0)?.main
                description.text = response.body()?.current?.weatherBody?.get(0)?.description
                Glide
                    .with(requireContext())
                    .load(
                        "http://openweathermap.org/img" +
                                "/wn/${response.body()?.current?.weatherBody?.get(0)}.png"
                    )
                    //картинки с опенвезер не открываются
                    .error(requireContext().getDrawable(R.drawable.ic_launcher_foreground))
                    .into(weatherIcon)
            }

            override fun onFailure(call: Call<TmpI>, t: Throwable) {
            }

        })


    }

}