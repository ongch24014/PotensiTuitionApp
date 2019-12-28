package com.example.potensituitionapp.addcourse

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.Transformations
import com.example.potensituitionapp.database.CourseDao
import com.example.potensituitionapp.formatCourses

class AddcourseViewModel(val database: CourseDao,
                         application: Application) : AndroidViewModel(application){

    private val courses = database.getAllCourse()

    val showallcourse = Transformations.map(courses) { courses ->
        formatCourses(courses, application.resources)
    }

}