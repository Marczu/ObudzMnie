package com.marcinmejner.obudzmnie.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import com.marcinmejner.obudzmnie.utils.MyNotification
import com.marcinmejner.obudzmnie.model.SaveData
import android.support.v4.content.ContextCompat.startActivity
import com.marcinmejner.obudzmnie.alarm.AlarmActivity


class MyBroadcastReciver: BroadcastReceiver(){
    private val TAG = "MyBroadcastReciver"

    override fun onReceive(context: Context?, intent: Intent?) {

        if(intent?.action.equals("com.tester.alarmmanager")){
            var b = intent?.extras
//            val notify = MyNotification(context).apply { displayNotification() }
            Log.d(TAG, "onReceive: alarm uruchomiony")
            initAlarmActivity(context)
        }
        else if(intent?.action.equals("android.permission.RECEIVE_BOOT_COMPLETED")){
            val saveData = SaveData(context!!)
            saveData.setAlarm()


        }
    }

    fun initAlarmActivity(context: Context?){
        val alarmIntent = Intent(context, AlarmActivity::class.java)
        alarmIntent.flags = Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT or Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_PREVIOUS_IS_TOP
        alarmIntent.setAction("android.intent.action.VIEW")
        alarmIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        alarmIntent.setAction(Intent.ACTION_MAIN)
        alarmIntent.addCategory(Intent.CATEGORY_LAUNCHER)
        startActivity(context!!, alarmIntent, null)
    }

}