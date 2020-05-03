package com.example.telstrapoc.utils

import android.app.Application
import android.content.Context
//Gives the Context of application
class CountryFeatureApplication : Application(){
    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }
    companion object {
        lateinit var context: Context
    }
}