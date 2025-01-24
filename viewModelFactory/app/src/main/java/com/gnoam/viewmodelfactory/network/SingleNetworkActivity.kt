package com.gnoam.viewmodelfactory.network

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gnoam.viewmodelfactory.R

class SingleNetworkActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_single_network)
    }

    private fun setupObserver() {
        viewModel.get
    }
}