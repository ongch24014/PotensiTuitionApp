package com.example.potensituitionapp.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface PaymentDao {

    @Insert
    fun insert(payment: Payment)

    @Update
    fun update(payment: Payment)

    @Query("SELECT * from payment_table WHERE num = :key")
    fun get(key: Long): Payment?

    @Query("SELECT * from payment_table WHERE student_ID = :key")
    fun getPayment(key: String): Payment?

    @Query("DELETE FROM payment_table")
    fun clear()

    @Query("SELECT * FROM payment_table ORDER BY student_ID DESC LIMIT 1")
    fun getLastPayment(): Payment

    @Query("SELECT * FROM payment_table ORDER BY num DESC")
    fun getAllPayment(): LiveData<List<Payment>>


}