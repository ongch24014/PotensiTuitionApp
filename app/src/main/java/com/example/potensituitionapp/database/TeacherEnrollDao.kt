package com.example.potensituitionapp.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface TeacherEnrollDao {
    @Insert
    fun insert(teacherEnroll: TeacherEnroll)

    @Update
    fun update(teacherEnroll: TeacherEnroll)

    @Query("SELECT class_name FROM teacherenroll_table WHERE teacher_ID = :key")
    fun getClasses(key: String): Array<String>

    @Query("SELECT class_ID FROM teacherenroll_table WHERE class_name = :key")
    fun getClassId(key: String): String

}