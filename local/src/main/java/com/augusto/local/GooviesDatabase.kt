package com.augusto.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.augusto.local.dao.MovieDao
import com.augusto.local.entity.MovieEntity

@Database(entities = [MovieEntity::class], version = 1)
abstract class GooviesDatabase : RoomDatabase() {
    abstract fun moviesDao(): MovieDao
    companion object {
        const val name = "GooviesDB"
    }
}