package com.ruyn.basekoltinproject.base
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.ruyn.basekoltinproject.api.BaseResponse
import io.reactivex.disposables.CompositeDisposable


/**
 * Copyright (C) 2019.
 * All rights reserved.
 *
 * @author ruyn.
 * @since May-17-2019
 */
open class BaseViewModel: ViewModel(){
    val eventLoading = MutableLiveData<Event<Boolean>>()
    val eventError = MutableLiveData<Event<BaseResponse>>()
    val eventFailure = MutableLiveData<Event<Throwable>>()
    val disposables = CompositeDisposable()

    fun showLoading(value: Boolean) {
        eventLoading.value = Event(value)
    }

    fun showError(baseResponse: BaseResponse) {
        eventError.value = Event(baseResponse)
    }

    fun showFailure(throwable: Throwable) {
        eventFailure.value = Event(throwable)
    }
}