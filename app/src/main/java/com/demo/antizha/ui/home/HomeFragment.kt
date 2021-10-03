package com.demo.antizha.ui.home

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.demo.antizha.R
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        ViewModelProvider(this).get(HomeViewModel::class.java).also { homeViewModel = it }
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val dateList = generateDate()
        root.findViewById<TextView>(R.id.home_text_1).text = dateList[0]
        root.findViewById<TextView>(R.id.home_text_2).text = dateList[1]
        root.findViewById<TextView>(R.id.home_text_3).text = dateList[2]
        root.findViewById<TextView>(R.id.home_text_4).text = dateList[3]
        root.findViewById<TextView>(R.id.home_text_5).text = dateList[4]
        return root
    }

    @SuppressLint("SimpleDateFormat")
    private fun generateDate():ArrayList<String>{
        val dateList = ArrayList<String>()
        val time = Calendar.getInstance().time
        val calendar = Calendar.getInstance()
        calendar.time = time
        with(calendar){
            set(Calendar.DATE, calendar.get(Calendar.DATE) - 1)
        }
        val df = SimpleDateFormat("yyyy-MM-dd")
        val date1 = df.format(calendar.time)
        val head = "国家反诈中心 "
        with(dateList){
            add("$head$date1 ${randomFormat((21..23).random())}:${randomFormat((0..59).random())}:${randomFormat((0..59).random())}")
            add("$head$date1 ${randomFormat((18..20).random())}:${randomFormat((0..59).random())}:${randomFormat((0..59).random())}")
            add("$head$date1 ${randomFormat((13..17).random())}:${randomFormat((0..59).random())}:${randomFormat((0..59).random())}")
            add("$head$date1 ${randomFormat((7..12).random())}:${randomFormat((0..59).random())}:${randomFormat((0..59).random())}")
            add("$head$date1 ${randomFormat((0..6).random())}:${randomFormat((0..59).random())}:${randomFormat((0..59).random())}")
        }
        return dateList
    }

    private fun randomFormat(time:Int):String{
        if (time < 10){
            return "0$time"
        }
        return time.toString()
    }

}