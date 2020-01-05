package com.example.potensituitionapp.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface TimetableDao {
    @Insert
    fun insert(timetable: Timetable)

    @Update
    fun update(timetable: Timetable)

    @Query("SELECT * from timetable_table WHERE num = :key")
    fun get(key: Long): Timetable?

    @Query("SELECT * from timetable_table WHERE class_ID = :key")
    fun getTimetable(key: String): Timetable?

    @Query("DELETE FROM timetable_table")
    fun clear()

    @Query("SELECT * FROM timetable_table ORDER BY class_ID DESC LIMIT 1")
    fun getLastTimetable(): Timetable

    @Query("SELECT * FROM timetable_table ORDER BY class_ID DESC")
    fun getAllTimetable(): LiveData<List<Timetable>>

    @Query("SELECT timetable_table.* FROM timetable_table INNER JOIN enrollment_table ON enrollment_table.class_ID = timetable_table.class_ID  AND enrollment_table.student_ID = :key ORDER BY CASE class_day WHEN 'Monday' THEN 1 WHEN 'Tuesday' THEN 2 WHEN 'Wednesday' THEN 3 WHEN 'Thursday' THEN 4 WHEN 'Friday' THEN 5 END ")
    fun getStudentTimeTable(key: String): LiveData<List<Timetable>>

    @Query("SELECT * FROM timetable_table WHERE class_ID = :key")
    fun getSpecificTimetable(key:String): LiveData<List<Timetable>>

    @Query("SELECT * from timetable_table WHERE teacher_ID = :key")
    fun getTeacherClass(key: String): LiveData<List<Timetable>>

    @Query("SELECT * from chapter_table WHERE class_ID = :key")
    fun getChapter(key: String): LiveData<Chapter>

}