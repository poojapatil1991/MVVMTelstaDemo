package com.example.telstrapoc.utils

import android.app.Application
import android.content.Context

class CountryFeatureApplication : Application(){
    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }
    companion object {
        lateinit var context: Context
    }
}