package com.leothos.twoactivities.controllers

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import com.leothos.twoactivities.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_MESSAGE: String = "com.leothos.twoactivities.extra.Message"
        const val TEXT_REQUEST = 1
        private val LOG_TAG: String = MainActivity::class.java.simpleName
    }

    var message: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState != null) {
            val isVisible = savedInstanceState.getBoolean("reply_visible")
            if (isVisible) {
                text_header_reply.visibility = View.VISIBLE
                text_message_reply.text = savedInstanceState.getString("reply_text")
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        if (text_header_reply.visibility == View.VISIBLE) {
            outState?.putBoolean("reply_visible", true)
            outState?.putString("reply_text", text_message_reply.text.toString())
        }
    }

    fun launchSecondActivity(view: View) {
        Log.d(LOG_TAG, "launchSecondActivity button is clicked!")
        //Retrieve message from edit text
        message = edit_Text_main!!.text.toString()
        Log.d(LOG_TAG, "intent value = $message")
        val intent = Intent(this@MainActivity, SecondActivity::class.java)
        intent.putExtra(EXTRA_MESSAGE, message)
        startActivityForResult(intent, TEXT_REQUEST)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == TEXT_REQUEST) {
            if (resultCode == Activity.RESULT_OK) {
                val reply = data!!.getStringExtra(SecondActivity.EXTRA_REPLY)
                Log.d(LOG_TAG, "reply from second activity $reply")
                text_header_reply.visibility = View.VISIBLE
                text_message_reply.setText(reply).toString()
            }
        }
    }
}
