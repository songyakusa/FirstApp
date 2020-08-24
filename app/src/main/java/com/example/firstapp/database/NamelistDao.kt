package com.example.firstapp.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.newfirstapp.database.Namelist

@Dao
interface NamelistDao {
    @Insert
    fun insertName(namelist: Namelist)

    @Query("SELECT * FROM namelist_table ORDER BY namelistId DESC")
    fun getName(): LiveData<List<Namelist>>

}