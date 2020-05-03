package com.example.telstrapoc.executer

import rx.Scheduler

interface IExecuterThread {
    fun getScheduler(): Scheduler?
}