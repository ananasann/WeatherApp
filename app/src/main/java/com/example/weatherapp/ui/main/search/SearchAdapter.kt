package com.example.weatherapp.ui.main.search

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Filter
import android.widget.TextView
import androidx.annotation.LayoutRes
import com.example.weatherapp.R
import com.example.weatherapp.data.SearchItem

class SearchAdapter(
    context: Context,
    @LayoutRes val resource: Int,
    private var data: List<SearchItem>,
    private val onClickListener: SearchItemClickListener
) : ArrayAdapter<SearchItem>(
    context,
    resource,
    data
) {
    private val searchFilter: SearchFilter = SearchFilter()

    override fun getFilter(): Filter {
        return searchFilter
    }

    override fun getCount(): Int {
        return data.size
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var v = convertView

        if (v == null) {
            val vi: LayoutInflater = LayoutInflater.from(context)
            v = vi.inflate(resource, null)
        }

        val item: SearchItem = data[position]
        val a: TextView? = v?.findViewById(R.id.search_item_text)
        a?.text = item.name
        v?.setOnClickListener {
            onClickListener.onClick(item.coordinates)
        }

        return v!!
    }

    inner class SearchFilter : Filter() {
        override fun publishResults(
            charSequence: CharSequence?,
            filterResults: Filter.FilterResults
        ) {
            data = filterResults.values as List<SearchItem>
            notifyDataSetChanged()
        }

        override fun performFiltering(charSequence: CharSequence?): Filter.FilterResults {
            val queryString = charSequence?.toString()?.toLowerCase()

            val filterResults = Filter.FilterResults()
            filterResults.values = if (queryString == null || queryString.isEmpty())
                data
            else
                data.filter {
                    it.name.lowercase().contains(queryString)
                }
            return filterResults
        }
    }
}