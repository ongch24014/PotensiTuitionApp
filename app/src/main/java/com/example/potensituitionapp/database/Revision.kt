package com.example.potensituitionapp.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "revision_table")
data class Revision (

    @PrimaryKey(autoGenerate = true)
    var num: Long = 0L,

    @ColumnInfo(name = "class_id")
    var classID: String = "",

    @ColumnInfo(name = "chap_num")
    var chapNum: String = "",

    @ColumnInfo(name = "stud_id")
    var studID: String = "",

    @ColumnInfo(name = "content")
    var content: String = ""

)