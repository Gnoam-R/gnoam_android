package com.gnoam.viewmodelfactory.local.Dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.gnoam.viewmodelfactory.local.Entity.User

@Dao
interface UserDao {

    @Query("SELECT * FROM user")
    fun getAll(): List<User>

    @Insert
    fun insertAll(users: List<User>)

    @Delete
    fun delete(user: User)

}