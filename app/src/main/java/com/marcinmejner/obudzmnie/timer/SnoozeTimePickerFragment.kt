package com.marcinmejner.obudzmnie.timer


import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.NumberPicker

import com.marcinmejner.obudzmnie.R

class SnoozeTimePickerFragment :  DialogFragment() {

    lateinit var picker: NumberPicker

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_snooze_time_picker, container, false)

        picker = view.findViewById(R.id.numberPicker)

        setNumberPicker()
        return view
    }

    fun setNumberPicker() {
        picker.minValue = 1
        picker.maxValue = 100
        picker.wrapSelectorWheel = false
    }


}
