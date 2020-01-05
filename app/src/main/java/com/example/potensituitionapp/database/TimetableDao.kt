package com.example.potensituitionapp.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface TimetableDao {
    @Insert
    fun insert(timetable: Timetable)

    @Update
    fun update(timetable: Timetable)

    @Query("DELETE FROM timetable_table WHERE class_ID = :key")
    fun delete(key: String)

    @Query("SELECT * from timetable_table WHERE num = :key")
    fun get(key: Long): Timetable?

    @Query("SELECT * from timetable_table WHERE class_ID = :key")
    fun getTimetable(key: String): Timetable?

    @Query("SELECT student_table.* FROM student_table INNER JOIN enrollment_table ON enrollment_table.student_ID = student_table.student_ID INNER JOIN timetable_table ON timetable_table.class_ID = enrollment_table.class_ID WHERE enrollment_table.class_ID = :key")
    fun getStudents(key: String): LiveData<List<Student>>

    @Query("SELECT class_name FROM timetable_table WHERE teacher_ID = :key")
    fun getClasses(key: String): List<String>

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

    @Query("SELECT class_name FROM enrollment_table WHERE student_ID = :key")
    fun getStudentClass(key:String): LiveData<List<String>>

}