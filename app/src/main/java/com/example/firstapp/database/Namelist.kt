package com.example.newfirstapp.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "namelist_table")
data class Namelist(

    @PrimaryKey(autoGenerate = true)
    var namelistId: Long = 0L,

    @ColumnInfo(name = "name")
    var name: String = ""
)