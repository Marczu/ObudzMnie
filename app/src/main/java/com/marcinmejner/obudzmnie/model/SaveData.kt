package com.marcinmejner.obudzmnie.model

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
    var sp: SharedPreferences? = null
    lateinit var alarmManager: AlarmManager
    lateinit var pi:PendingIntent

    constructor(context:Context){
        this.context = context
        this.sp = context.getSharedPreferences(context.getString(R.string.shared_prefs), Context.MODE_PRIVATE)
        alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
    }

    fun saveData(hour: Int, minute: Int){
        val edit = sp?.edit()
        edit?.putInt(context?.getString(R.string.sp_hour), hour)
        edit?.putInt(context?.getString(R.string.sp_minute), minute)
        edit?.commit()
    }

    fun gethour(): Int?{
        return sp?.getInt(context?.getString(R.string.sp_hour), 0)
    }

    fun getMinute(): Int?{
        return sp?.getInt(context?.getString(R.string.sp_minute), 0)
    }

    fun setAlarm(){

        val hour = gethour()
        val minute = getMinute()

        val calendar = Calendar.getInstance()
        calendar.set(Calendar.HOUR_OF_DAY, hour!!)
        calendar.set(Calendar.MINUTE, minute!!)
        calendar.set(Calendar.SECOND, 0)

//        alarmManager = context?.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val intent = Intent(context, MyBroadcastReciver::class.java)
        intent.putExtra(context?.getString(R.string.intent_message), "alarm time")
        intent.action = "com.tester.alarmmanager"

        pi = PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)

        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.timeInMillis,
                AlarmManager.INTERVAL_DAY, pi)

    }

    fun setCancelAlarm(){
        alarmManager.cancel(pi)
    }


}