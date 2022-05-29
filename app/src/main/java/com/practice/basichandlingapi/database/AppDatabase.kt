package com.practice.basichandlingapi.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.practice.basichandlingapi.models.Photo

@Database(entities = [Photo::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun photoDao():PhotoDao

    companion object{
        //Singleton Instantiation
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context):AppDatabase{
            //If the INSTANCE is not null then, return it
            //If it is then, create the database
            return INSTANCE?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "api-db"
                )
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}