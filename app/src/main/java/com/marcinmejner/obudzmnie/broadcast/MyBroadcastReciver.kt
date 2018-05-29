package com.marcinmejner.obudzmnie.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.marcinmejner.obudzmnie.utils.MyNotification


class MyBroadcastReciver: BroadcastReceiver(){
    private val TAG = "MyBroadcastReciver"

    override fun onReceive(context: Context?, intent: Intent?) {

        if(intent?.action.equals("com.tester.alarmmanager")){
            var b = intent?.extras
            val notify = MyNotification(context).apply { displayNotification() }
        }
    }

}