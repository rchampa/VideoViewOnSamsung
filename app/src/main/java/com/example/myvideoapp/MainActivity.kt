package com.example.myvideoapp

import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
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
    }

    fun getUri() : Uri {

        val videoPath = "android.resource://" + applicationContext.packageName + "/"
        val uri = Uri.parse(videoPath + R.raw.background)
        return uri
    }
}
