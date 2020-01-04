package com.example.potensituitionapp.enrollment

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.potensituitionapp.database.CourseDao
import com.example.potensituitionapp.database.TimetableDao

class EnrollmentViewModelFactory(val dataSource: CourseDao,
                                 private val application: Application) : ViewModelProvider.Factory {

    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(EnrollmentViewModel::class.java)) {
            return EnrollmentViewModel(dataSource) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}