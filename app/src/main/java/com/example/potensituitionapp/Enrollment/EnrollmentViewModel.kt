package com.example.potensituitionapp.Enrollment

import android.app.Application

import androidx.lifecycle.AndroidViewModel


import com.example.potensituitionapp.database.CourseDao

public class EnrollmentViewModel(
    val database: CourseDao,
    application: Application
) : AndroidViewModel(application) {

  public val courses = database.getAllCourse()
}