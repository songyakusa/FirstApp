package com.example.firstapp.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface NamelistDao {
    @Insert
    fun insertName(namelist: Namelist)

    @Query("SELECT * FROM namelist_table ")
    fun getName(): LiveData<List<Namelist>>

}