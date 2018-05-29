package com.marcinmejner.obudzmnie.utils

import android.app.Notification
import android.app.NotificationManager
import android.content.Context
import android.graphics.Color
import android.media.RingtoneManager
import android.support.v4.app.NotificationCompat
import com.marcinmejner.obudzmnie.R

class MyNotification(val context: Context?) {

    fun displayNotification(){
        val builder = NotificationCompat.Builder(context)
        val alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
        builder.setAutoCancel(true)
                .setDefaults(Notification.DEFAULT_ALL)
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Mój alarm AKTYWOWANY")
                .setContentText("To jest moj alarm")
                .setDefaults(Notification.DEFAULT_SOUND)
                .setDefaults(Notification.DEFAULT_LIGHTS)
                .setLights(Color.BLUE, 500, 500)
                .setSound(alarmSound)
                .setContentInfo("Info")

        val notificationManager: NotificationManager = context?.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.notify(1, builder.build())
    }
}