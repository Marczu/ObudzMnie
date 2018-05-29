package com.marcinmejner.obudzmnie.timer

import android.os.Build
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v7.widget.AppCompatButton
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TimePicker
import com.marcinmejner.obudzmnie.R


class PopTimeFragment : DialogFragment() {
    private val TAG = "PopTimeFragment"

    //widgets
    lateinit var btnsave: AppCompatButton
    lateinit var btnCancel: AppCompatButton
    lateinit var timePicker: TimePicker

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_poptime, container, false)


        btnsave = view.findViewById(R.id.btn_save)
        timePicker = view.findViewById(R.id.timer_pickup)
        btnCancel = view.findViewById(R.id.btn_cancel)
        timePicker.setIs24HourView(true)

        saveTime()
        cancelDialog()

        return view
    }

    fun cancelDialog(){
        btnCancel.setOnClickListener {
            this.dismiss()
        }
    }

    fun saveTime() {
        btnsave.setOnClickListener {

            val timerActivity = activity as TimerActivity

            if (Build.VERSION.SDK_INT >= 23) {
                timerActivity.setTime(timePicker.hour, timePicker.minute)
            } else {
                timerActivity.setTime(timePicker.currentHour, timePicker.currentMinute)
            }
            this.dismiss()
        }
    }
}