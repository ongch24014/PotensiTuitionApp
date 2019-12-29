package com.example.potensituitionapp.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "teacher_table")
data class Teacher (
    @PrimaryKey(autoGenerate = true)
    var num: Long = 0L,

    @ColumnInfo(name = "teacher_ID")
    var teacherID: String = "",

    @ColumnInfo(name = "name")
    var name: String = "",

    @ColumnInfo(name = "password")
    var password: String ="",

    @ColumnInfo(name = "teacher_mobile_no")
    var teacherNumber: String = "",

    @ColumnInfo(name = "teacher_email")
    var teacherEmail: String = ""

)