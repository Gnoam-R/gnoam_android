package com.gnoam.kotlin_flow.api

import kotlinx.coroutines.flow.Flow

interface ApiHelper {
    fun getUser(): Flow<List<ApiUser>>

    fun getMoreUsers(): Flow<List<ApiUser>>

    fun getUserWIthError(): Flow<List<ApiUser>>
}