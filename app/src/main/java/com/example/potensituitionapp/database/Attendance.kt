package com.example.potensituitionapp.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "attendance_table")
data class Attendance(

    @PrimaryKey(autoGenerate = true)
    var num: Long = 0L,

    @ColumnInfo(name = "student_ID")
    var studentID: String = "",

    @ColumnInfo(name = "class_ID")
    var classID: String = "",

    @ColumnInfo(name = "status")
    var status: String = ""

)