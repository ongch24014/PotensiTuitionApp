package com.example.potensituitionapp.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "enrollment_table")
data class Enrollment (

    @PrimaryKey(autoGenerate = true)
    var num: Long = 0L,

    @ColumnInfo(name = "student_ID")
    var studentID: String = "",

    @ColumnInfo(name = "class_ID")
    var classID: String = "",

    @ColumnInfo(name = "class_name")
    var className: String = "",

    @ColumnInfo(name = "enrollment_date")
    var enrollmentDate: String = ""

)