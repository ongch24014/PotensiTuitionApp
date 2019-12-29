package com.example.potensituitionapp.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "payment_table")
data class Payment(

    @PrimaryKey(autoGenerate = true)
    var num: Long = 0L,

    @ColumnInfo(name = "bill_no")
    var billNo: Double = 0.0,

    @ColumnInfo(name = "bill_amount")
    var billAmount: Double = 0.0,

    @ColumnInfo(name = "payment_date")
    var paymentDate: String = "",

    @ColumnInfo(name = "payment_status")
    var paymentStatus: String = "",

    @ColumnInfo(name = "student_ID")
    var studentID: String = "",

    @ColumnInfo(name = "admin_ID")
    var adminID: String = ""

)