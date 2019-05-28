package com.ruyn.basekoltinproject.api

import com.ruyn.basekoltinproject.model.RepositoriesEntity
import com.ruyn.basekoltinproject.model.UserEntity
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Copyright (C) 2019.
 * All rights reserved.
 *
 * @author ruyn.
 * @since May-17-2019
 */
interface ApiInterface{
    @GET("/users/{user}")
    fun getUser(@Path("user") userId: String): Observable<UserEntity>

    @GET("/users/{user}/repos")
    fun getRepositories(@Path("user") userId: String): Observable<List<RepositoriesEntity>>

}