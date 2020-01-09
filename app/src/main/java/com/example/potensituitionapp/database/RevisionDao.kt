package com.example.potensituitionapp.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface RevisionDao {

    @Insert
    fun insert(revision: Revision)

    @Update
    fun update(revision: Revision)

    @Query("SELECT * from revision_table WHERE class_id = :key AND chap_num = :key1 AND stud_id = :key2")
    fun get(key: String,key1:String,key2:String): Revision

    @Query("DELETE FROM revision_table")
    fun clear()
}