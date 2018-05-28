package com.marcinmejner.obudzmnie

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_timer.*

class TimerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timer)


    }

    fun setTime(){

        btn_set_time.setOnClickListener {

        }
    }
}
