package com.gnoam.kotlin_flow.data.local

import com.gnoam.kotlin_flow.data.local.entity.User
import kotlinx.coroutines.flow.Flow

interface DatabaseHelper {
    fun getUsers(): Flow<List<User>>

    fun insertAll(users: List<User>):Flow<Unit>

}