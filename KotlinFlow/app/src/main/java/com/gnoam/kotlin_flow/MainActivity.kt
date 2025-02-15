package com.gnoam.kotlin_flow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gnoam.kotlin_flow.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}