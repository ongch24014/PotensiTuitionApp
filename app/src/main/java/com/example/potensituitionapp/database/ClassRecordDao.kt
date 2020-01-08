package com.example.potensituitionapp.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import java.sql.Time

@Dao
interface ClassRecordDao {

    @Insert
    fun insert(classRecord: ClassRecord)

    @Update
    fun update(classRecord: ClassRecord)

    @Query("SELECT * from class_record_table WHERE num = :key")
    fun get(key: Long): ClassRecord?

    @Query("SELECT * from class_record_table WHERE class_ID = :key")
    fun getClassRecord(key: String): List<ClassRecord>

    @Query("DELETE FROM class_record_table")
    fun clear()

    @Query("SELECT * FROM class_record_table ORDER BY class_ID DESC LIMIT 1")
    fun getLastClassRecord(): ClassRecord

    @Query("SELECT * FROM class_record_table ORDER BY num DESC")
    fun getAllClassRecord(): LiveData<List<ClassRecord>>

    @Query("SELECT * from timetable_table WHERE teacher_ID = :key1 AND class_day = :key2")
    fun getCurrentClass(key1:String, key2:String): Timetable

    @Query("SELECT * from class_record_table WHERE class_date = :key AND class_ID = :key1")
    fun getRecord(key: String, key1: String): ClassRecord

    @Query("SELECT * from class_record_table WHERE attendance_code = :key")
    fun getClassbyCode(key: String): ClassRecord

    @Query("SELECT * from enrollment_table WHERE class_ID = :key AND student_ID = :key1")
    fun getEnrollment(key: String, key1: String): Enrollment

    @Query("SELECT * from attendance_table WHERE class_ID = :key AND student_ID = :key1")
    fun getAttendanceClass(key: String, key1:String): Attendance

}