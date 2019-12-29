package com.example.potensituitionapp.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface AdminDao {

    @Insert
    fun insert(admin: Admin)

    @Update
    fun update(admin: Admin)

    @Query("SELECT * from admin_table WHERE admin_id = :key")
    fun get(key: Long): Admin?

    @Query("SELECT * from admin_table WHERE name = :key")
    fun getAdmin(key: String): Admin?

    @Query("DELETE FROM admin_table")
    fun clear()

    @Query("SELECT * FROM admin_table ORDER BY admin_id DESC LIMIT 1")
    fun getLastAdmin(): Admin

    @Query("SELECT * FROM admin_table ORDER BY admin_id DESC")
    fun getAllAdmins(): LiveData<List<Admin>>
}