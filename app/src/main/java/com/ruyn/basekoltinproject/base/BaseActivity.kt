package com.ruyn.basekoltinproject.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

/**
 * Copyright (C) 2019.
 * All rights reserved.
 *
 * @author ruyn.
 * @since May-17-2019
 */
abstract class BaseActivity:AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getRootLayoutId())
        setUpView(savedInstanceState)
    }

    abstract fun setUpView(savedInstanceState: Bundle?)

    abstract fun getRootLayoutId(): Int

}