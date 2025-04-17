package com.example.sharedpref

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    lateinit var userName : EditText
    lateinit var userMessage : EditText
    lateinit var counter : Button
    lateinit var remember : CheckBox

    var count : Int = 0

    var name:String? = null
    var message:String? = null
    var isChecked:Boolean? = null

    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        userName = findViewById(R.id.editTextName)
        userMessage = findViewById(R.id.editTextMessage)
        counter = findViewById(R.id.button)
        remember = findViewById(R.id.checkBox)

        counter.setOnClickListener {
            count ++
            counter.setText("" + count)
        }

    }

    override fun onPause() {
        super.onPause()
        saveData()
    }

    fun saveData() {
        sharedPreferences = this.getSharedPreferences("saveData", Context.MODE_PRIVATE)
        name = userName.text.toString()
        message = userMessage.text.toString()
        isChecked = remember.isChecked

        val editor = sharedPreferences.edit()
        editor.putString("key name", name)
        editor.putString("key message", message)
        editor.putInt("key count", count)
        editor.putBoolean("key remember", isChecked!!)
        editor.apply()

        Toast.makeText(applicationContext, "Yout Data is Saved", Toast.LENGTH_LONG).show()
    }
}