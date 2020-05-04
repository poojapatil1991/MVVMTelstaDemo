package com.example.telstrapoc.executer

import rx.Scheduler
import rx.android.schedulers.AndroidSchedulers

/*
UI Thread
 */
class UIThread : IExecuterThread {
    override fun getScheduler(): Scheduler? {
        return AndroidSchedulers.mainThread()
    }
}