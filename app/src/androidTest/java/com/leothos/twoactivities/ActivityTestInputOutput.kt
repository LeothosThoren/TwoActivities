package com.leothos.twoactivities

import android.app.Activity
import android.support.test.InstrumentationRegistry
import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.runner.AndroidJUnit4
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Rule
//    public val mRule: Activity =

    @Test
    fun launchActivity() {
        onView(withId(R.id.button_send)).perform(click())
        onView(withId(R.id.text_message_reply)).check(matches(isDisplayed()))
        onView(withId(R.id.button_reply)).perform(click())
        onView(withId(R.id.text_header_reply)).check(matches(isDisplayed()))
    }
}