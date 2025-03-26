package com.example.a2251120162_danghuynhkhai_tuan3bai2

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // Chờ 3 giây rồi chuyển sang màn hình onboarding
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, OnboardingActivity::class.java))
            finish() // Đóng SplashActivity
        }, 3000) // 3000ms = 3s
    }
}