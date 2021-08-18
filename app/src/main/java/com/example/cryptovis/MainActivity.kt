package com.example.cryptovis

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var mainHandler: Handler
    var numberDec = 1000

    private val updateTextTask = object : Runnable {
        override fun run() {
            minusOneSecond()
            mainHandler.postDelayed(this, 1000)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Logic here

        mainHandler = Handler(Looper.getMainLooper())
    }

     override fun onPause() {
        super.onPause()
        mainHandler.removeCallbacks(updateTextTask)
    }

    override fun onResume() {
        super.onResume()
        mainHandler.post(updateTextTask)
    }

    fun minusOneSecond() {
        numberDec = numberDec - 1
        val textView = findViewById(R.id.textViewNumDec) as TextView
        textView.text = numberDec.toString()
    }
}