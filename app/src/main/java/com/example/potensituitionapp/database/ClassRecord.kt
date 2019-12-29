package com.example.potensituitionapp.database


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "class_record_table")
data class ClassRecord (

    @PrimaryKey(autoGenerate = true)
    var num: Long = 0L,

    @ColumnInfo(name = "class_date")
    var classDate: String = "",

    @ColumnInfo(name = "class_ID")
    var classID: String = "",

    @ColumnInfo(name = "attendance_code")
    var attendanceCode: String = ""
)