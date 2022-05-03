package com.pru.splashapi

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.delay

class MainActivity : AppCompatActivity() {
    private var isSplashPending = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen().also {
            it.setKeepOnScreenCondition {
                isSplashPending
            }
        }
        setContentView(R.layout.activity_main)
        // simulating a Network/DB call
        lifecycleScope.launchWhenStarted {
            delay(2000)
            isSplashPending = false
        }
    }
}