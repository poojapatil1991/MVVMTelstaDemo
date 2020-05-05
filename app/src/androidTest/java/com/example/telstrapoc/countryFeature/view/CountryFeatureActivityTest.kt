package com.example.telstrapoc.countryFeature.view

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.Assert.*
import org.junit.Rule
import androidx.test.rule.ActivityTestRule
import com.example.telstrapoc.R
import kotlinx.android.synthetic.main.content_country_feature.*

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

}