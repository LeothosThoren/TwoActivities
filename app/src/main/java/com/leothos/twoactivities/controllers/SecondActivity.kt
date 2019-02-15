package com.leothos.twoactivities.controllers

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import com.leothos.twoactivities.R
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_REPLY = "com.leothos.twoactivities.controllers.extra.REPLY"
        private val LOG_TAG = SecondActivity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        //Methods
        this.messageReception()
    }

    //Intent Actions
    private fun messageReception() {
        val receivedMessage = intent.getStringExtra(MainActivity.EXTRA_MESSAGE)
        Log.d(LOG_TAG, "received message = $receivedMessage")
        textMessage_second.setText(receivedMessage).toString()
    }

    fun returnsReply(view: View) {
        Log.d(LOG_TAG, "returnReply button is clicked!")
        val reply = edit_Text_second.text.toString()
        val replyIntent = Intent(this@SecondActivity, MainActivity::class.java)
        replyIntent.putExtra(EXTRA_REPLY, reply)
        setResult(Activity.RESULT_OK, replyIntent)
        Log.d(LOG_TAG, "reply answer = $reply")
        finish()
    }
}
