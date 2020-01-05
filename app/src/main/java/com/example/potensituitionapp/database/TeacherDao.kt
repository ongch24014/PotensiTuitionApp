package com.example.potensituitionapp.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface TeacherDao {
    @Insert
    fun insert(teacher: Teacher)

    @Update
    fun update(teacher: Teacher)

    @Query("SELECT * from teacher_table WHERE teacher_ID = :key")
    fun get(key: String): Teacher?

    @Query("SELECT * from teacher_table WHERE name = :key")
    fun getTeacher(key: String): Teacher?

    @Query("DELETE FROM teacher_table")
    fun clear()

    @Query("SELECT * FROM teacher_table ORDER BY teacher_ID DESC LIMIT 1")
    fun getLastTeacher(): Teacher

    @Query("SELECT * FROM teacher_table ORDER BY teacher_ID DESC")
    fun getAllTeachers(): LiveData<List<Teacher>>
}