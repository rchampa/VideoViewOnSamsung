package com.example.myvideoapp

import android.content.res.Configuration
import android.content.res.Configuration.*
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        videoBackground.setVideoURI(getUri())
        videoBackground.setOnPreparedListener{ mp ->
            mp.start()
            mp.isLooping = true
        }

        videoBackground.setOnErrorListener{ mp, what, extra ->
            mp.reset()
            videoBackground.setVideoURI(getUri())
            true
        }

        checkSize()
    }

    fun getUri() : Uri {

        val videoPath = "android.resource://" + applicationContext.packageName + "/"
        val uri = Uri.parse(videoPath + R.raw.background)//not working :(
//        val uri = Uri.parse(videoPath + R.raw.background_no_audio)//working!!! (no audio signal)
        return uri
    }

    fun checkSize(){
        val screenSize = resources.configuration.screenLayout and SCREENLAYOUT_SIZE_MASK
        when(screenSize){
            SCREENLAYOUT_SIZE_SMALL -> { Log.d("MEHHHH","small") }
            SCREENLAYOUT_SIZE_NORMAL -> { Log.d("MEHHHH","normal") }
            SCREENLAYOUT_SIZE_LARGE -> { Log.d("MEHHHH","large") }
            SCREENLAYOUT_SIZE_XLARGE -> { Log.d("MEHHHH","xlarge") }
            SCREENLAYOUT_SIZE_UNDEFINED -> { Log.d("MEHHHH","undefined") }
        }
    }
}
