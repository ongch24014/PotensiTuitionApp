package com.example.potensituitionapp.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "admin_table")
data class Admin (

    @PrimaryKey(autoGenerate = true)
    var num: Long = 0L,

    @ColumnInfo(name = "admin_id")
    var adminID: String = "",

    @ColumnInfo(name = "name")
    var name: String = "",

    @ColumnInfo(name = "password")
    var password: String = ""

)