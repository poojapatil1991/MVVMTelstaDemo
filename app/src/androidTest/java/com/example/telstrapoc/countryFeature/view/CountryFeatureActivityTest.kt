package com.example.telstrapoc.countryFeature.view

import android.content.Intent
import androidx.appcompat.app.ActionBar
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import org.junit.Assert.*
import androidx.test.rule.ActivityTestRule
import com.example.telstrapoc.R
import kotlinx.android.synthetic.main.content_country_feature.*
import org.junit.*

class CountryFeatureActivityTest {

    @get:Rule
    var mActivityRule :ActivityTestRule<CountryFeatureActivity> = ActivityTestRule<CountryFeatureActivity>(CountryFeatureActivity::class.java)
    lateinit var mCountryFeatureActivity: CountryFeatureActivity
    @Before
    fun setUp() {
        mCountryFeatureActivity = mActivityRule.activity
    }

    @After
    fun tearDown() {
    }

    @Test
    fun onCreate() {
        var rvCountryFeature = mCountryFeatureActivity.rv_country_feature
        assertNotNull(rvCountryFeature)
    }

    @Test
    fun testSwipeRefresh(){
        onView(withId(R.id.swipe_refresh)).perform(ViewActions.swipeDown())
    }

    @Test
    fun testRecyclerViewScrollUp(){
        onView(withId(R.id.rv_country_feature)).perform(ViewActions.swipeUp())
    }

    @Test
    fun testRecyclerViewScrollDown(){
        onView(withId(R.id.rv_country_feature)).perform(ViewActions.swipeDown())
    }

    @Test
    fun testRecyclerViewScrolling(){
        onView(withId(R.id.rv_country_feature)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
    @Test
    fun testActionBarTitleDisplay(){
        val actionBar: ActionBar?= mCountryFeatureActivity.supportActionBar
        Assert.assertNotNull(actionBar!!.title)
    }

}