package com.example.potensituitionapp.enrollment

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


import com.example.potensituitionapp.database.CourseDao

class EnrollmentViewModel( val database: CourseDao,
                           application: Application
) : AndroidViewModel(application) {

   val courses = database.getAllCourse()
      get() = field

    fun onCourseClicked(id: String) {
        _navigateToCourse.value = id
    }

    private val _navigateToCourse = MutableLiveData<String>()
    val navigateToCourse
    get() = _navigateToCourse

    fun onCourseNavigated() {
        _navigateToCourse.value = null
    }
}