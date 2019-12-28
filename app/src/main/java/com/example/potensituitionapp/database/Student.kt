package com.example.potensituitionapp.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "student_table")
data class Student(
    @PrimaryKey(autoGenerate = true)
    var studentID: Long = 0L,

    @ColumnInfo(name = "name")
    var name: String = "",

    @ColumnInfo(name = "password")
    var password: String ="",

    @ColumnInfo(name = "student_address")
    var studentAddress: String = "",

    @ColumnInfo(name = "student_mobile_no")
    var studentNumber: String = ""

)