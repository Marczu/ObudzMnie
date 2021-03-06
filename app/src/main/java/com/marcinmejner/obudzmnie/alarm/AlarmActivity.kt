package com.marcinmejner.obudzmnie.alarm

import android.media.MediaPlayer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.view.WindowManager
import com.marcinmejner.obudzmnie.R
import com.marcinmejner.obudzmnie.model.SaveData
import com.marcinmejner.obudzmnie.utils.TimeManipulations
import kotlinx.android.synthetic.main.activity_alarm.*

class AlarmActivity : AppCompatActivity() {
    lateinit var player: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initSetupScreen()

        startAlarm()
        stopAlarm()
        snoozeButton()
    }

    private fun initSetupScreen() {
        /*Activity pop in lock screen*/
        window.apply {
            addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED)
            addFlags(WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD)
            addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
            addFlags(WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON)
        }

        setContentView(R.layout.activity_alarm)
    }

    fun startAlarm(){
        player = MediaPlayer.create(this, R.raw.alarm1)
        player.isLooping = true
        player.start()
    }

    fun stopAlarm(){
        btn_stop_alarm.setOnClickListener {
            player.stop()

            finish()
        }
    }

    fun snoozeButton(){
        btn_snooze.setOnClickListener {

            val saveData = SaveData(this)
            saveData.setSnooze()
            player.stop()
            finish()

        }
    }



    override fun onDestroy() {
        super.onDestroy()
        player.stop()
    }
}
