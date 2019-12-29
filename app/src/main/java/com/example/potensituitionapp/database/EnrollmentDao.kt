package com.example.potensituitionapp.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface EnrollmentDao {

    @Insert
    fun insert(enrollment: Enrollment)

    @Update
    fun update(enrollment: Enrollment)

    @Query("SELECT * from enrollment_table WHERE num = :key")
    fun get(key: Long): Enrollment?

    @Query("SELECT * from enrollment_table WHERE student_ID = :key")
    fun getEnrollment(key: String): List<Enrollment>

    @Query("DELETE FROM enrollment_table")
    fun clear()

    @Query("SELECT * FROM enrollment_table ORDER BY class_ID DESC LIMIT 1")
    fun getLastEnrollment(): Enrollment

    @Query("SELECT * FROM enrollment_table ORDER BY student_ID DESC")
    fun getAllEnrollment(): LiveData<List<Enrollment>>


}