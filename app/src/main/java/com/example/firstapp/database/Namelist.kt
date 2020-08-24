package com.example.firstapp.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "namelist_table")
data class Namelist (

    @PrimaryKey(autoGenerate = true)

    @ColumnInfo(name = "contactList_name")
    var name:String

)