package com.demo.antizha

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val timer = Timer()
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.background_splash)
        val it = Intent(this, MainActivity::class.java)
        val timerTask = object : TimerTask() {
            override fun run() {
                startActivity(it)
                finish()
            }
        }
        timer.schedule(timerTask, 3000)
    }
}
