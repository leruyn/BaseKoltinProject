package com.ruyn.basekoltinproject.api

import com.ruyn.basekoltinproject.BuildConfig
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Copyright (C) 2019.
 * All rights reserved.
 *
 * @author ruyn.
 * @since May-17-2019
 */
class ApiBuilder() {
    companion object {
        private val apiInterface: ApiInterface? = null
        fun getWebService(): ApiInterface {
            if (apiInterface != null) {
                return apiInterface
            }

            val retrofit = Retrofit.Builder().baseUrl(BuildConfig.API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
            return retrofit.create(ApiInterface::class.java)
        }
    }
}