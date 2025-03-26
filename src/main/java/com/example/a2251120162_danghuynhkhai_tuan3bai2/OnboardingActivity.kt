package com.example.a2251120162_danghuynhkhai_tuan3bai2

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.a2251120162_danghuynhkhai_tuan3bai2.adapter.OnboardingAdapter
import com.example.a2251120162_danghuynhkhai_tuan3bai2.model.OnboardingItem

class OnboardingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)

        val viewPager = findViewById<ViewPager2>(R.id.viewPager)
        val btnNext = findViewById<Button>(R.id.btnNext)
        val btnBack = findViewById<Button>(R.id.btnBack)

        val items = listOf(
            OnboardingItem(R.drawable.image1, "Easy Time Management", "With management based on priority and daily tasks, it will give you convenience in managing and determining the tasks that must be done first "),
            OnboardingItem(R.drawable.image2, "Increase Work Effectiveness", "Time management and the determination of more important tasks will give your job statistics better and always improve"),
            OnboardingItem(R.drawable.image3, "Reminder Notification", "The advantage of this application is that it also provides reminders for you so you don't forget to keep doing your assignments well and according to the time you have set")
        )

        val adapter = OnboardingAdapter(items)
        viewPager.adapter = adapter

        // Sự kiện bấm nút Next
        btnNext.setOnClickListener {
            if (viewPager.currentItem < items.size - 1) {
                viewPager.currentItem += 1
            } else {
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }
        }

        // Sự kiện bấm nút Back
        btnBack.setOnClickListener {
            if (viewPager.currentItem > 0) {
                viewPager.currentItem -= 1
            }
        }

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                btnBack.visibility = if (position == 0) View.GONE else View.VISIBLE
                if (position == items.size - 1) {
                    btnNext.text = "Get Started "
                } else {
                    btnNext.text = "Next"
                }
            }
        })
    }
}