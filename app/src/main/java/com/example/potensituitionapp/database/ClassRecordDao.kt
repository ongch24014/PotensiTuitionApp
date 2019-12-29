package com.example.potensituitionapp.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

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

}