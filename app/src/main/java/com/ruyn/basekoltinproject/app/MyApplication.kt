package com.ruyn.basekoltinproject.app

import android.app.Application
import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent
import android.arch.lifecycle.ProcessLifecycleOwner
import android.util.Log

/**
 * Copyright (C) 2019.
 * All rights reserved.
 *
 * @author ruyn.
 * @since May-17-2019
 */
class MyApplication:Application(), LifecycleObserver{
    override fun onCreate() {
        super.onCreate()
    }

    private fun setupLifecycleListener(){
        ProcessLifecycleOwner.get().lifecycle.addObserver(this)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onMoveToForeground(){
        Log.d("RLV", "Returning to foreground")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onMoveToBackground(){
        Log.d("RLV", " Moving to background")
    }
}