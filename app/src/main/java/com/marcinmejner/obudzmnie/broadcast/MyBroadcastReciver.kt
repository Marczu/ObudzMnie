package com.marcinmejner.obudzmnie.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import com.marcinmejner.obudzmnie.utils.MyNotification
import com.marcinmejner.obudzmnie.utils.SaveData


class MyBroadcastReciver: BroadcastReceiver(){
    private val TAG = "MyBroadcastReciver"

    override fun onReceive(context: Context?, intent: Intent?) {

        if(intent?.action.equals("com.tester.alarmmanager")){
            var b = intent?.extras
            val notify = MyNotification(context).apply { displayNotification() }
            Log.d(TAG, "onReceive: alarm uruchomiony")
        }
        else if(intent?.action.equals("android.permission.RECEIVE_BOOT_COMPLETED")){
            val saveData = SaveData(context!!)
            saveData.setAlarm()


        }
    }

}