package com.marcinmejner.obudzmnie.timer

import android.content.Context
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.marcinmejner.obudzmnie.R
import com.marcinmejner.obudzmnie.model.SaveData
import com.marcinmejner.obudzmnie.utils.TimeManipulations
import kotlinx.android.synthetic.main.activity_timer.*

class TimerActivity : AppCompatActivity() {
    private val TAG = "TimerActivity"

    //vars
    lateinit var saveData: SaveData
    lateinit var sp: SharedPreferences
    lateinit var editor: SharedPreferences.Editor

    //time
    var myHour: String = ""
    var myMinutes: String = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timer)


        sp = this.getSharedPreferences(this.getString(R.string.shared_prefs), Context.MODE_PRIVATE)
        editor = sp.edit()

        saveData = SaveData(applicationContext)
        tv_alarm.text = saveData.gethour().toString() + ":" + saveData.getMinute().toString()

        btn_set_time.setOnClickListener {
            val popTimer = PopTimeFragment()
            val fm = supportFragmentManager
            popTimer.show(fm, getString(R.string.select_time))
        }

        checkForExistingAlarm()

        cancelAlarm()


    }




    fun setTime(hours: Int, minutes: Int) {

        myHour = hours.toString()
        myMinutes = minutes.toString()
        if (hours < 10) {
            myHour = "0$myHour"
        }
        if (minutes < 10) {
            myMinutes = "0$myMinutes"
        }

        ustawiony_czas.visibility = View.VISIBLE

        saveData = SaveData(applicationContext)
        Log.d(TAG, "setTime: godzina: $hours : minuty: $minutes")

        /*save in shared prefs*/
        saveData.saveData(hours, minutes)

        saveData.setAlarm()
        btn_cancel_alarm.visibility = View.VISIBLE

        checkIfItIsToomorow()
        tv_alarm.text = myHour + ":" + myMinutes
    }

    fun cancelAlarm() {
        btn_cancel_alarm.setOnClickListener {
            saveData.setCancelAlarm()
            editor.putInt(this.getString(R.string.sp_hour), -1)
            editor.putInt(this.getString(R.string.sp_minute), -1)
            editor.commit()

            ustawiony_czas.text = "Brak ustawionych alarmów"
            tv_alarm.text = ""
            btn_cancel_alarm.visibility = View.GONE
        }
    }

    fun checkForExistingAlarm() {
        if (sp.getInt(getString(R.string.sp_hour), -100) == -1) {
            ustawiony_czas.visibility = View.VISIBLE
            ustawiony_czas.text = "Brak ustawionych alarmów"
            tv_alarm.text = ""
            Log.d(TAG, "checkForExistingAlarm: sp bez alarmu: ${sp.getInt(getString(R.string.sp_hour), -1)}   ${sp.getInt(getString(R.string.sp_minute), -1)}")

        }
        else{

            if (sp.getInt(getString(R.string.sp_hour), -1) < 10) {
                myHour = "0${sp.getInt(getString(R.string.sp_hour), -1)}"
            } else{
                myHour = "${sp.getInt(getString(R.string.sp_hour), -1)}"
            }
            if (sp.getInt(getString(R.string.sp_minute), -1) < 10) {
                myMinutes = "0${sp.getInt(getString(R.string.sp_minute), -1)}"
            }else{
                myMinutes = "${sp.getInt(getString(R.string.sp_minute), -1)}"
            }

            tv_alarm.text = myHour + ":" + myMinutes


            saveData.setAlarm()
            checkIfItIsToomorow()
            ustawiony_czas.visibility = View.VISIBLE
            btn_cancel_alarm.visibility = View.VISIBLE
            Log.d(TAG, "checkForExistingAlarm: ${sp.getInt(getString(R.string.sp_hour), -1)}   ${sp.getInt(getString(R.string.sp_minute), -1)}")

        }

    }

    fun checkIfItIsToomorow(){
        val timeManip = TimeManipulations()
        if(saveData.isTommorow){
            ustawiony_czas.text = "Następny alarm: ${timeManip.timeTomorrow()}," +
                    " $myHour:$myMinutes"
        }else{
            ustawiony_czas.text = "Alarm ustawiony na godzinę:"
        }
    }
}
