package com.marcinmejner.obudzmnie.utils

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import com.marcinmejner.obudzmnie.R
import com.marcinmejner.obudzmnie.broadcast.MyBroadcastReciver
import java.util.*

class SaveData{

    var context:Context?=null

    constructor(context:Context){
        this.context=context

    }

    fun setAlarm(hour: Int, minute: Int){

        val calendar = Calendar.getInstance()
        calendar.set(Calendar.HOUR_OF_DAY, hour)
        calendar.set(Calendar.MINUTE, minute)
        calendar.set(Calendar.SECOND, 0)

        val alarmManager = context?.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val intent = Intent(context, MyBroadcastReciver::class.java)
        intent.putExtra(context?.getString(R.string.intent_message), "alarm time")
        intent.action = "com.tester.alarmmanager"

        val pi = PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)

        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.timeInMillis,
                AlarmManager.INTERVAL_DAY, pi)
    }
}