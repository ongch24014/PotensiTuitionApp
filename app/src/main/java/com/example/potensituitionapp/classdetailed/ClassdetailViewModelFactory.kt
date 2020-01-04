package com.example.potensituitionapp.classdetailed

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.potensituitionapp.database.ChapterDao

class ClassdetailViewModelFactory(private val class_ID: String,
                                  val dataSource: ChapterDao,
                               private val application: Application
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ClassdetailViewModel::class.java)) {
            return ClassdetailViewModel(class_ID,dataSource, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}