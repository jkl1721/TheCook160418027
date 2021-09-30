package com.ubaya.thecook160418027.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ubaya.thecook160418027.R
import androidx.core.content.ContextCompat
import com.google.android.material.bottomnavigation.BottomNavigationView




class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView = findViewById<BottomNavigationView>(R.id.bottomNav)
        navView.setBackgroundColor(
            ContextCompat.getColor(
                applicationContext,
                android.R.color.transparent
            )
        )
    }
}