package com.example.potensituitionapp.Enrollment

import android.app.Application
import android.view.View
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.example.potensituitionapp.database.Course
import com.example.potensituitionapp.database.CourseDao
import com.example.potensituitionapp.database.EnrollmentDao
class EnrollmentViewModel(
    val database: CourseDao,
    application: Application
) : AndroidViewModel(application) {

   val course = database.getAllCourse()
}