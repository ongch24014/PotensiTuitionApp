package com.example.potensituitionapp.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "timetable_table")
data class Timetable (
    @PrimaryKey(autoGenerate = true)
    var num: Long = 0L,

    @ColumnInfo(name = "class_ID")
    var classID: String = "",

    @ColumnInfo(name = "class_name")
    var className: String = "",

    @ColumnInfo(name = "class_venue")
    var classVenue: String = "",

    @ColumnInfo(name = "class_time")
    var classTime: Int,

    @ColumnInfo(name = "class_day")
    var classDay: String = "",

    @ColumnInfo(name = "teacher_ID")
    var teacherID: String = "",

    @ColumnInfo(name = "course_ID")
    var courseID: String = ""

)