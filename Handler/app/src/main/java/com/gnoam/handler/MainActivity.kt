package com.gnoam.handler

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
<<<<<<< Updated upstream
import android.os.Handler
import android.os.HandlerThread
import android.os.Looper
import android.os.Message
import android.util.Log
import android.widget.TextView
=======
import android.os.Looper
>>>>>>> Stashed changes

class MainActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

<<<<<<< Updated upstream
        val mTextView = findViewById<TextView>(R.id.tv_main)

//         test1
        /*
        val mHandler = Handler(Looper.getMainLooper())
        test_Handler1(mHandler, mTextView)


         */

        // test2
        /*
        val eThread = HandlerThread("myThread")
        val mLooper = eThread.looper

        val mHandler2 = Handler(mLooper)
        //  test2에 대한 메서드 실행시 오류(MainThread 관련)
        //  test_Handler2(mHandler2, mTextView)


         */

        // test3


        val mHandler3 = object : Handler(Looper.getMainLooper()) {
            override fun handleMessage(msg: Message) {
                super.handleMessage(msg)
                val user = msg.obj as User
                Log.e("test" , "mHandler3-------test log$user")
                mTextView.text = "mHandler3"
            }
        }
        test_Handler3(mHandler3, mTextView)
=======
        Looper.
>>>>>>> Stashed changes
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

data class User(val id: String, val name: String)

private fun test_Handler3(mHandler: Handler, mTextView: TextView) {
//    val message = Message.obtain()
    val message = mHandler.obtainMessage()
    message.obj = User("1", "roh")

    Log.e("test" , "mHandler3-------before")
    mHandler.sendMessage(message)
    Log.e("test" , "mHandler3-------after")
}

