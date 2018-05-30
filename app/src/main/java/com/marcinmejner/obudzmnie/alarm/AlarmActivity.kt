package com.marcinmejner.obudzmnie.alarm

import android.media.MediaPlayer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import com.marcinmejner.obudzmnie.R
import kotlinx.android.synthetic.main.activity_alarm.*

class AlarmActivity : AppCompatActivity() {
    lateinit var player: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alarm)
        startAlarm()
        stopAlarm()
    }

    fun startAlarm(){
        player = MediaPlayer.create(this, Settings.System.DEFAULT_RINGTONE_URI)
        player.isLooping = true
        player.start()
    }

    fun stopAlarm(){
        btn_stop_alarm.setOnClickListener {
            player.stop()

            finish()
        }
    }
}
