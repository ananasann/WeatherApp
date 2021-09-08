package com.example.weatherapp.ui.main

import android.content.Context
import androidx.annotation.NonNull
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.weatherapp.R
import java.lang.Exception

private val TAB_TITLES = arrayOf(
    R.string.tab_text_1,
    R.string.tab_text_2
)

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
class SectionsPagerAdapter(
    fm: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fm,lifecycle) {

    //private val context: Context = this.
    private val todayFrag: TodayFrag = TodayFrag()
    private val sevenDayFrag: SevenDayFrag = SevenDayFrag()


    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> todayFrag
            1 -> sevenDayFrag
            else -> throw Exception("No more page")
        }
    }



    /* override fun getItem(position: Int): Fragment {
         // getItem is called to instantiate the fragment for the given page.
         // Return a PlaceholderFragment (defined as a static inner class below).
         return PlaceholderFragment.newInstance(position + 1)
     }

     override fun getPageTitle(position: Int): CharSequence? {
         return context.resources.getString(TAB_TITLES[position])
     }

     override fun getCount(): Int {
         // Show 2 total pages.
         return 2
     }*/
}