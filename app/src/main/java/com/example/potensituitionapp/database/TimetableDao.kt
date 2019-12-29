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
}