package com.example.potensituitionapp.enrollment

import androidx.lifecycle.ViewModel


import com.example.potensituitionapp.database.CourseDao

class EnrollmentViewModel( val database: CourseDao

) : ViewModel(){
    val datastuct= database
  public val courses = datastuct.getAllCourse()
      get() = field
}