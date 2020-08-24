package com.example.firstapp.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface NamelistDao {
    @Insert
    suspend fun insertNamelist(contactList: Namelist):Long

    @Query("SELECT * FROM namelist_table")
    fun getAllContactList(): LiveData<List<Namelist>>

    @Update
    suspend fun updateContactList(contactList: Namelist): Int
}