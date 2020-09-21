package com.augusto.local.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.augusto.local.entity.MovieEntity

@Dao
interface MovieDao {

    @Insert
    fun addMovies(list: List<MovieEntity>)


    @Query("SELECT * FROM movieentity")
    fun getMovies(): List<MovieEntity>
}
