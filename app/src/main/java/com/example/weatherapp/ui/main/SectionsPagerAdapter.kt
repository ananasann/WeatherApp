package com.example.weatherapp.ui.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.weatherapp.ui.main.search.SearchFragment
import com.example.weatherapp.ui.main.seven_day.SevenDayFrag
import com.example.weatherapp.ui.main.todayfrog.TodayFrag

class SectionsPagerAdapter(
    fm: FragmentManager, lifecycle: Lifecycle
) :
    FragmentStateAdapter(fm, lifecycle) {

    private val todayFrag: TodayFrag = TodayFrag()
    private val sevenDayFrag: SevenDayFrag = SevenDayFrag()
    private val searchFrag: SearchFragment = SearchFragment()

    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> searchFrag
            1 -> todayFrag
            2 -> sevenDayFrag
            else -> throw Exception("No more page")
        }
    }
}