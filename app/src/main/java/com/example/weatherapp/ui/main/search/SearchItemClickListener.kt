package com.example.weatherapp.ui.main.search

import com.example.weatherapp.data.Coordinates

interface SearchItemClickListener {
    fun onClick(coords: Coordinates)
}