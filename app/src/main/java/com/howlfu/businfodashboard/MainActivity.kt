package com.howlfu.businfodashboard

import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import java.util.*
import android.util.Log


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        testWhenCreate()
        hideSystemUI()
        initSpeaker()
    }

    private var tts: TextToSpeech? = null
    private fun initSpeaker() {
        tts = TextToSpeech(applicationContext, TextToSpeech.OnInitListener { status ->
            if (status == TextToSpeech.SUCCESS) {
                val ttsLang = tts!!.setLanguage(Locale.ENGLISH)
                if (ttsLang == TextToSpeech.LANG_MISSING_DATA || ttsLang == TextToSpeech.LANG_NOT_SUPPORTED) {
                    println( "The Language is not supported!")
                } else {
                    println("Language Supported.")
                }
                println( "Initialization success.")

                Toast.makeText(applicationContext, "Initialization success.", Toast.LENGTH_SHORT)
                    .show()
            } else {
                Toast.makeText(applicationContext, "TTS Initialization failed!", Toast.LENGTH_SHORT)
                    .show()
            }
        })
    }
    private fun speak(txt: String) {
        val speechStatus = tts!!.speak(txt, TextToSpeech.QUEUE_FLUSH, null)
        if (speechStatus == TextToSpeech.ERROR)
        {
            Toast.makeText(applicationContext, "Error in converting Text to Speech", Toast.LENGTH_SHORT)
                .show()
        }
    }

    private fun testWhenCreate(){
//        val text1 = findViewById<TextView>(R.id.text1)
//        text1.text = getString(R.string.main_title1_add)
//        text1.setOnClickListener {
//            pressTextViewHandler()
//        }
    }

    private fun pressTextViewHandler() {
//        val text2 = findViewById<TextView>(R.id.text2)
//        text2.text = getString(R.string.main_title2_add)
//
//        speak("123")
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