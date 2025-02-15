package com.gnoam.viewmodelfactory

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.gnoam.viewmodelfactory.network.SingleNetworkActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        SingleNetworkActivity()
    }

    fun startSingleNetworkActivity(view: View) {
        startActivity(Intent(this@MainActivity, SingleNetworkActivity::class.java))
    }

}