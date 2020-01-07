package com.example.potensituitionapp.enrollment

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel


import com.example.potensituitionapp.database.CourseDao

class EnrollmentViewModel( val database: CourseDao,
                           application: Application
) : AndroidViewModel(application) {

   val courses = database.getAllCourse()
      get() = field
}