package com.example.weatherapp

import android.os.Bundle
import com.google.android.material.tabs.TabLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.weatherapp.data.converter.*
import com.example.weatherapp.ui.main.SectionsPagerAdapter
import com.example.weatherapp.databinding.ActivityMainBinding
import com.example.weatherapp.domain.*
import com.google.android.material.tabs.TabLayoutMediator
import com.google.gson.GsonBuilder

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val sectionsPagerAdapter = SectionsPagerAdapter(supportFragmentManager, lifecycle)
        val viewPager: ViewPager2 = binding.viewPager
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = binding.tabs

        TabLayoutMediator(
            tabs,
            viewPager
        ) { tab, position ->
            when (position) {
                0 -> tab.text = getString(R.string.tab_text_1)
                1 -> tab.text = getString(R.string.tab_text_2)
            }
        }.attach()


    }
}