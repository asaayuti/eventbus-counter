package com.sayuti.eventbus

interface CounterListener {
    fun onCounterChanged(newValue: Int)
}