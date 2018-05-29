package com.marcinmejner.obudzmnie.timer

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.marcinmejner.obudzmnie.R
import com.marcinmejner.obudzmnie.R.id.*
import com.marcinmejner.obudzmnie.utils.SaveData
import kotlinx.android.synthetic.main.activity_timer.*

class TimerActivity : AppCompatActivity() {
    private val TAG = "TimerActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timer)

        btn_set_time.setOnClickListener {
            val popTimer = PopTimeFragment()
            val fm = supportFragmentManager
            popTimer.show(fm, getString(R.string.select_time))
        }
    }



    fun setTime(hours: Int, minutes: Int){

        var myHour:String = hours.toString()
        var myMinutes:String = minutes.toString()
        if(hours<10){
            myHour = "0$myHour"
        }
        if(minutes<10){
            myMinutes = "0$myMinutes"
        }

        tv_alarm.text = myHour + ":" + myMinutes
        ustawiony_czas.visibility = View.VISIBLE

        val saveData = SaveData(applicationContext)
        Log.d(TAG, "setTime: godzina: $hours : minuty: $minutes")
        saveData.setAlarm(hours, minutes)
    }
}
