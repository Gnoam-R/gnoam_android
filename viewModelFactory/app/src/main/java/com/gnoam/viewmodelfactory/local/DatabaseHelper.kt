package com.gnoam.viewmodelfactory.local

import com.gnoam.viewmodelfactory.local.Entity.User
import kotlinx.coroutines.flow.Flow

interface DatabaseHelper {

    fun getUsers(): Flow<List<User>>

    fun insertAll(users: List<User>): Flow<Unit>

}