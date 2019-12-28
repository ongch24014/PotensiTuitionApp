package com.example.potensituitionapp.addcourse

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.potensituitionapp.database.CourseDao

class AddcourseViewModelFactory(private val dataSource: CourseDao,
                                private val application: Application) : ViewModelProvider.Factory{

    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AddcourseViewModel::class.java)) {
            return AddcourseViewModel(dataSource, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}