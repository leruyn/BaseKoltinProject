package com.ruyn.basekoltinproject.function.home

import android.arch.lifecycle.MutableLiveData
import android.util.Log
import com.ruyn.basekoltinproject.api.ApiBuilder
import com.ruyn.basekoltinproject.base.BaseViewModel
import com.ruyn.basekoltinproject.model.RepositoriesEntity
import com.ruyn.basekoltinproject.model.UserEntity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
/**
 * Copyright (C) 2019.
 * All rights reserved.
 *
 * @author ruyn.
 * @since May-17-2019
 */
class UserViewModel : BaseViewModel() {
    private val userResponse = MutableLiveData<UserEntity>()
    private var repositoriesResponse = MutableLiveData<List<RepositoriesEntity>>()

    fun showUserInfo(): MutableLiveData<UserEntity> {
        return userResponse
    }

    fun showRepositories(): MutableLiveData<List<RepositoriesEntity>> {
        return repositoriesResponse
    }

    fun getUserInfo(userId: String) {
        disposables.add(
            ApiBuilder.getWebService().getUser(userId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { showLoading(true) }
            .doFinally { showLoading(false) }
            .subscribe({
                userResponse.value = it
            }, {
                showFailure(it)
            }))
    }

    fun getRepositories(userId: String) {
        disposables.add(ApiBuilder.getWebService().getRepositories(userId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { showLoading(true) }
            .doFinally { showLoading(false) }
            .subscribe({
                repositoriesResponse.value = it
            }, {
                showFailure(it)
            }))
    }

    override fun onCleared() {
        Log.d("UserViewModel", "onCleared")
        disposables.clear()
    }
}
