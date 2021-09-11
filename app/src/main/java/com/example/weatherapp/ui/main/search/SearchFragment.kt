package com.example.weatherapp.ui.main.search

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.SearchView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.weatherapp.MainActivity
import com.example.weatherapp.R
import com.example.weatherapp.data.Coordinates
import com.example.weatherapp.data.SearchItem
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import java.io.IOException
import java.lang.reflect.Type

class SearchFragment : Fragment(), SearchItemClickListener {

    private lateinit var searchView: SearchView
    private lateinit var adapter: SearchAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.search_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        searchView = view.findViewById(R.id.search_fragment__search_view)
        val json = getJsonDataFromAsset(requireContext(), jsonCityListFileName)
        val type: Type = object : TypeToken<List<SearchItem>>() {}.type
        val builder: Gson = GsonBuilder().create()
        val parsedData: List<SearchItem> =
            builder.fromJson(json, type)

        adapter = SearchAdapter(
            requireContext(),
            R.layout.search_item,
            parsedData,
            this
        )

        val searchList = view.findViewById<ListView>(R.id.search_fragment__list_view)
        searchList.adapter = adapter
    }

    override fun onClick(coords: Coordinates) {
        Toast.makeText(
            requireContext(),
            "Город успешно сохранен! Идите в соседние вкладки!",
            Toast.LENGTH_SHORT
        ).show()
        (activity as MainActivity).setCoordinates(coords)
    }

    override fun onResume() {
        super.onResume()

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextChange(p0: String?): Boolean {
                adapter.filter.filter(p0)
                return false
            }

            override fun onQueryTextSubmit(p0: String?): Boolean {
                searchView.clearFocus()
                adapter.filter.filter(p0)
                return false
            }
        })
    }


    private fun getJsonDataFromAsset(context: Context, fileName: String): String? {
        val jsonString: String
        try {
            jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            return null
        }
        return jsonString
    }

    companion object {
        private const val jsonCityListFileName: String = "city_list.json"
    }
}