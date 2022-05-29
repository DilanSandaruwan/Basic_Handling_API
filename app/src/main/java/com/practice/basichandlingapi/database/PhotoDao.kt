package com.practice.basichandlingapi.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.practice.basichandlingapi.models.Photo

@Dao
interface PhotoDao {

    @Query("SELECT * FROM Photo")
    fun getAllPhotoFromDB(): List<Photo>

    @Insert
    fun insertPhoto(vararg photo: Photo)

}