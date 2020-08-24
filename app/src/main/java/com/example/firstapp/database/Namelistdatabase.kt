package com.example.firstapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Namelist::class], version = 1, exportSchema = false)
abstract  class Namelistdatabase : RoomDatabase() {

    abstract val contactDao: NamelistDao

    companion object {

        @Volatile
        private var INSTANCE: Namelistdatabase? = null

        fun getInstance(context: Context): Namelistdatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        Namelistdatabase::class.java,
                        "contact_data_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}