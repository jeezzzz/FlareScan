package com.jeezzzz.flarescan

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.RelativeLayout
import android.widget.VideoView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    lateinit var videoView:VideoView
    lateinit var fwiVideoView:VideoView
    lateinit var bottomNavigationView:BottomNavigationView
    lateinit var sensorButton:Button
    lateinit var fwiScoreButton:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        videoView = findViewById(R.id.video_view)
        val videoPath = "android.resource://" + packageName + "/" + R.raw.bg_video // Replace "your_video_file" with your actual video filename (without extension)
        videoView.setVideoURI(Uri.parse(videoPath))
        videoView.setOnCompletionListener {
            videoView.start() // Restart video playback
        }
        videoView.start()
        fwiVideoView = findViewById(R.id.fwi_score_background_video)
        val fwiVideoPath = "android.resource://" + packageName + "/" + R.raw.fwi_score_bg_video // Replace "your_video_file" with your actual video filename (without extension)
        fwiVideoView.setVideoURI(Uri.parse(fwiVideoPath))
        fwiVideoView.setOnCompletionListener {
            fwiVideoView.start() // Restart video playback
        }
        fwiVideoView.start()
        sensorButton=findViewById(R.id.sensor_button)
        fwiScoreButton=findViewById(R.id.fwi_score_button)
        sensorButton.setOnClickListener{
            val intent=Intent(this, SensorsWebView::class.java)
            startActivity(intent)
        }
        fwiScoreButton.setOnClickListener{
            val intent=Intent(this, FWIScoreWebView::class.java)
            startActivity(intent)
        }
    }
}