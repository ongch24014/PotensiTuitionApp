package com.example.potensituitionapp.database


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.FileDescriptor

@Entity(tableName = "course_table")
data class Course (
    @PrimaryKey(autoGenerate = true)
    var num: Long = 0L,

    @ColumnInfo(name = "course_ID")
    var courseID: String = "",

    @ColumnInfo(name = "course_name")
    var courseName: String = "",

    @ColumnInfo(name = "description")
    var courseDescripton: String = "",

    @ColumnInfo(name = "course_price")
    var coursePrice: Double = 0.0


)