package com.marcinmejner.obudzmnie.utils

import android.util.Log
import java.text.SimpleDateFormat
import java.util.*



class TimeManipulations{
    private val TAG = "TimeManipulations"

    val calendar = Calendar.getInstance()
    val calendar2 = Calendar.getInstance()

    fun timeTomorrow(): String{

        calendar.timeZone = TimeZone.getTimeZone("Europe/Warsaw")

        calendar.time
        calendar2.time
        Log.d(TAG, "timeTomorrow: teraźniejsza data: ${calendar.time}")

        calendar.add(Calendar.DAY_OF_WEEK, 1)
        val weekdayPlusOne = calendar.time

        val sdf = SimpleDateFormat("EEEE")
        val tomorowDate = sdf.format(weekdayPlusOne)
        val today = sdf.format(calendar2.time)

        Log.d(TAG, "getTime: $tomorowDate i $today")

        return tomorowDate
    }
}