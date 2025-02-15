package com.gnoam.viewmodelfactory.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.gnoam.viewmodelfactory.local.Dao.UserDao
import com.gnoam.viewmodelfactory.local.Entity.User

@Database(entities = [User::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

}