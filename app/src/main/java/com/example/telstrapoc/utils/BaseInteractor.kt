package com.example.telstrapoc.utils

import rx.Subscriber

interface BaseInteractor<T> {
    fun execute(subscriber: Subscriber<T>)
}