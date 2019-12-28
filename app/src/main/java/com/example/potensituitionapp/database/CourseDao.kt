package com.example.potensituitionapp.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface CourseDao {
    @Insert
    fun insert(course: Course)

    @Update
    fun update(course: Course)

    @Query("SELECT * from course_table WHERE num = :key")
    fun get(key: Long): Course?

    @Query("SELECT * from course_table WHERE course_ID = :key")
    fun getCourse(key: String): Course?

    @Query("DELETE FROM course_table")
    fun clear()

    @Query("SELECT * FROM course_table ORDER BY course_ID DESC LIMIT 1")
    fun getLastCourse(): Course

    @Query("SELECT * FROM course_table ORDER BY course_ID DESC")
    fun getAllCourse(): LiveData<List<Course>>
}