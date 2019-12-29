package com.example.potensituitionapp.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface ChapterDao {

    @Insert
    fun insert(chapter: Chapter)

    @Update
    fun update(chapter: Chapter)

    @Query("SELECT * from chapter_table WHERE num = :key")
    fun get(key: Long): Chapter?

    @Query("SELECT * from chapter_table WHERE class_ID = :key")
    fun getAllChapter(key: String): List<Chapter>

    @Query("SELECT * from chapter_table WHERE class_ID = :key AND chapter_num = :chap")
    fun getChapter(key: String, chap: Int): Chapter

    @Query("DELETE FROM chapter_table")
    fun clear()

}