package com.gnoam.handler

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.HandlerThread
import android.os.Looper
import android.util.Log
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mTextView = findViewById<TextView>(R.id.tv_main)

//         test1
        val mHandler = Handler(Looper.getMainLooper())
        test_Handler1(mHandler, mTextView)

        // test2
        val eThread = HandlerThread("myThread")
        val mLooper = eThread.looper

        val mHandler2 = Handler(mLooper)
        //  test2에 대한 메서드 실행시 오류(MainThread 관련)
        //  test_Handler2(mHandler2, mTextView)

    }
}


private fun test_Handler1(mHandler: Handler, mTextView: TextView) {
    val mRunable = Runnable {
        run {
            mTextView.text = "use handler"
        }
    }
    mHandler.post(mRunable)
}

// UIThread 에 대한 변경은 Main 쓰레드에서 이루어 져야함
private fun test_Handler2(mHandler: Handler, mTextView: TextView) {
    val mRunable = Runnable {
        run {
            mTextView.text = "use handler"
        }
    }
    mHandler.post(mRunable)
}