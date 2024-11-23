package com.gnoam.coroutine

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity1004"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        main()
    }

    fun main() = runBlocking {
        doWorld()

        Log.e(TAG, "finish")
    }


    suspend fun doWorld() = coroutineScope {
        launch {
            delay(2000L)
            Log.e(TAG, "world2")
        }
        launch {
            delay(1000L)
            Log.e(TAG, "world1")
        }
        Log.e(TAG, "hello")
    }


}