package com.example.weatherapp.ui.main.seven_day

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.weatherapp.R
import com.example.weatherapp.data.DailyBody
import java.time.Instant
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*


class SevenDaysAdapter(
    val context: Context
) :
    RecyclerView.Adapter<SevenDaysAdapter.MyViewHolder>() {
    private var mInflater: LayoutInflater = LayoutInflater.from(context)

    private var mData: List<DailyBody> = arrayListOf()

    fun setList(value: List<DailyBody>) {
        mData = value
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = mInflater.inflate(R.layout.elemet_for_seven, parent, false)
        return MyViewHolder(view, context)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        return holder.bind(mData[position])
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    class MyViewHolder(view: View, context: Context) :
        RecyclerView.ViewHolder(view) {
        private lateinit var dt: TextView
        private lateinit var descrDaily: TextView
        private lateinit var dailyIcon: ImageView
        private lateinit var dayTemp: TextView

        @RequiresApi(Build.VERSION_CODES.O)
        @SuppressLint("UseCompatLoadingForDrawables")
        fun bind(dailyBody: DailyBody) {
            dt = itemView.findViewById(R.id.dt)
            descrDaily = itemView.findViewById(R.id.descr_daily)
            dailyIcon = itemView.findViewById(R.id.daily_icon)
            dayTemp = itemView.findViewById(R.id.day_temp)
            dt.text = toLocalDate(dailyBody.dt)
                .format(DateTimeFormatter.ofPattern("dd LLLL"))
            descrDaily.text = dailyBody.weatherBody[0].description
            dayTemp.text = dailyBody.tempBody.day.toString()
            Glide
                .with(itemView.context)
                .load("https://img.icons8.com/ios/500/sun--v3.png"
                    /*"http://openweathermap.org/img" +
                            "/wn/${dailyBody.weatherBody[0].icon}@2x.png"*/)
                //не отображаются картинки с апишки
                .into(dailyIcon)
        }

        @RequiresApi(Build.VERSION_CODES.O)
        private fun toLocalDate(value: Int): LocalDateTime {
            return LocalDateTime.ofInstant(
                Instant.ofEpochSecond(value.toLong()),
                TimeZone.getDefault().toZoneId()
            )
        }
    }
}