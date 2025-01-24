package com.gnoam.viewmodelfactory

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gnoam.viewmodelfactory.network.SingleNetworkActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun startSingleNetworkActivity() {
        startActivity(Intent(this@MainActivity, SingleNetworkActivity::class.java))
    }
}