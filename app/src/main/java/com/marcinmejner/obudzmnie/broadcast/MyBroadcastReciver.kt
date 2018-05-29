package com.marcinmejner.obudzmnie.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.support.constraint.Constraints.TAG
import android.util.Log
import android.widget.Toast
import com.marcinmejner.obudzmnie.R

class MyBroadcastReciver: BroadcastReceiver(){
    private val TAG = "MyBroadcastReciver"

    override fun onReceive(context: Context?, intent: Intent?) {
        if(intent!!.action.equals("com.tester.alarmmanager")){
            var b = intent.extras
            Toast.makeText(context,  b.getString(context!!.getString(R.string.intent_message)), Toast.LENGTH_LONG).show()
            Log.d(TAG, "onReceive: alarm zadziałał")
        }
    }

}