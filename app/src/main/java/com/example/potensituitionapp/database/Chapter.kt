package com.example.potensituitionapp.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "chapter_table")
data class Chapter (

    @PrimaryKey(autoGenerate = true)
    var num: Long = 0L,

    @ColumnInfo(name = "class_ID")
    var classID: String = "",

    @ColumnInfo(name = "chapter_num")
    var chapterNum: Int = 0,

    @ColumnInfo(name = "chapter_desc")
    var chapterDesc: String = "",

    @ColumnInfo(name = "chapter_audio")
    var chapterAudio: String = "",

    @ColumnInfo(name = "chapter_pdf")
    var chapterPDF: String = ""

    )