package com.example.telstrapoc.module

import com.example.telstrapoc.executer.BackgroundThread
import com.example.telstrapoc.executer.IExecuterThread
import com.example.telstrapoc.executer.UIThread

class ThreadModule {
    //Function returns the background thread
    fun provideExecutorThread(): IExecuterThread {
        return BackgroundThread()
    }

    // Function returns the UI thread
    fun providePostExecutionThread(): UIThread {
        return UIThread()
    }
}