package com.jeezzzz.flarescan

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class FWIScoreWebView : AppCompatActivity() {

    private lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fwiscore_web_view)

        webView = findViewById(R.id.web_view)
        webView.settings.javaScriptEnabled = true
        webView.webViewClient= WebViewClient()
        webView.loadUrl("https://flare-scan-fwi.streamlit.app/")
    }
}