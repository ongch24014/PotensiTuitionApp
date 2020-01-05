package com.example.potensituitionapp.teacherdetailclass

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.potensituitionapp.database.TimetableDao
import com.example.potensituitionapp.teacherpage.TeacherdetailclassViewModel

class TeacherdetailclassViewModelFactory  (val dataSource: TimetableDao,
                                           private val application: Application
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TeacherdetailclassFragment::class.java)) {
            return TeacherdetailclassViewModel(dataSource, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
