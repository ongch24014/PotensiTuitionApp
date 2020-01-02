package com.example.potensituitionapp.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface StudentDatabaseDao {
    @Insert
    fun insert(student: Student)

    @Update
    fun update(student: Student)

    @Query("SELECT * from student_table WHERE num = :key")
    fun get(key: Long): Student?

    @Query("SELECT * from student_table WHERE name = :key")
    fun getStudent(key: String): Student?

    @Query("DELETE FROM student_table")
    fun clear()

    @Query("SELECT * FROM student_table ORDER BY num DESC LIMIT 1")
    fun getLastStudent(): Student

    @Query("SELECT * FROM student_table ORDER BY num DESC")
    fun getAllStudents(): LiveData<List<Student>>
}