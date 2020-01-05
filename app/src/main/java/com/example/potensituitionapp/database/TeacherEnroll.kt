package com.example.potensituitionapp.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "teacherenroll_table")

data class TeacherEnroll (
    @PrimaryKey(autoGenerate = true)
    var num: Long = 0L,

    @ColumnInfo(name = "teacher_ID")
    var teacherID: String = "",

    @ColumnInfo(name = "class_ID")
    var classID: String = "",

    @ColumnInfo(name = "class_name")
    var className: String = ""



)