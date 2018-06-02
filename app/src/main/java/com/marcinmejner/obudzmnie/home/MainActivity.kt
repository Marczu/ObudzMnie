package com.marcinmejner.obudzmnie.home

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.marcinmejner.obudzmnie.R
import com.marcinmejner.obudzmnie.timer.TimerActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_add_new_alarm.setOnClickListener {
            val intent = Intent(this@MainActivity, TimerActivity::class.java)
            startActivity(intent)
        }
    }
}
