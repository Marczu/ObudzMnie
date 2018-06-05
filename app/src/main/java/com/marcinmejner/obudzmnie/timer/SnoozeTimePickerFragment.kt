package com.marcinmejner.obudzmnie.timer


import android.os.Bundle
import android.support.constraint.Constraints.TAG
import android.support.v4.app.DialogFragment
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.NumberPicker
import android.widget.TextView

import com.marcinmejner.obudzmnie.R
import kotlinx.android.synthetic.main.fragment_snooze_time_picker.*

class SnoozeTimePickerFragment :  DialogFragment() {
    private val TAG = "SnoozeTimePickerFragmen"

    lateinit var picker: NumberPicker
    lateinit var cancelDialog: TextView
    lateinit var saveDialog: TextView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_snooze_time_picker, container, false)
        picker = view.findViewById(R.id.numberPicker)
        cancelDialog = view.findViewById(R.id.cancelDialog)
        saveDialog = view.findViewById(R.id.save_dialog)


        setNumberPicker()

        return view
    }

    fun setNumberPicker() {
        picker.minValue = 1
        picker.maxValue = 100
        picker.wrapSelectorWheel = false

        cancelDialog.setOnClickListener {
            SnoozeTimePickerFragment@this.dismiss()
            Log.d(TAG, "setNumberPicker: wcisnieto auluj")
        }

        saveDialog.setOnClickListener {
            picker.setOnValueChangedListener { picker, oldVal, newVal ->


            }
            Log.d(TAG, "setNumberPicker: wybrany numer to ")
        }


    }


}
