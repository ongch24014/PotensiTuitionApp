package com.example.potensituitionapp.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface AttendanceDao {
    @Insert
    fun insert(attendance: Attendance)

    @Update
    fun update(attendance: Attendance)

    @Query("SELECT * from attendance_table WHERE student_ID = :key")
    fun getAttendanceStudent(key: String): Attendance?

    @Query("SELECT * from attendance_table WHERE class_ID = :key")
    fun getAttendanceClass(key: String): Attendance?

    @Query("DELETE FROM attendance_table")
    fun clear()

    @Query("SELECT * FROM attendance_table ORDER BY student_ID DESC LIMIT 1")
    fun getLastAttendance(): Attendance

    @Query("SELECT * FROM attendance_table ORDER BY num DESC")
    fun getAllAttendances(): LiveData<List<Attendance>>
}