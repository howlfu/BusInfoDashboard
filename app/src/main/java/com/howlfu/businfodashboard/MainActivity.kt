package com.howlfu.businfodashboard

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        testWhenCreate()
        hideSystemUI()
    }

    private fun testWhenCreate(){
        val text1 = findViewById<TextView>(R.id.text1)
        text1.text = getString(R.string.main_title1_add)
        text1.setOnClickListener {
            pressTextViewHandler()
        }
    }

    private fun pressTextViewHandler() {
        val text2 = findViewById<TextView>(R.id.text2)
        text2.text = getString(R.string.main_title2_add)
    }

    private fun hideSystemUI() {
        var mainContainer = window.decorView
        WindowCompat.setDecorFitsSystemWindows(window, false)
        WindowInsetsControllerCompat(window, mainContainer).let { controller ->
            controller.hide(WindowInsetsCompat.Type.systemBars())
            controller.systemBarsBehavior = WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        }
    }
}