package com.example.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class BroadcastRec : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val isAirPlaneMode : Boolean = intent!!.getBooleanExtra("state", false)

        if (isAirPlaneMode) {
            Toast.makeText(context, "The Device is in Airplane Mode", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(context, "The Device is in Airplane Mode", Toast.LENGTH_LONG).show()
        }
    }
}