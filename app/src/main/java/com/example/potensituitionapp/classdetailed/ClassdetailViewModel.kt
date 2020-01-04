package com.example.potensituitionapp.classdetailed

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.potensituitionapp.MainActivity
import com.example.potensituitionapp.database.ChapterDao

class ClassdetailViewModel(private val class_ID: String,
                           val database: ChapterDao,
                           application: Application
) : AndroidViewModel(application) {

    private val _navigateToDetailClass = MutableLiveData<String>()
    val navigateToDetailClass
        get() = _navigateToDetailClass

    val chapters = database.getAllChapter(class_ID)

    fun onChapterDetailClicked(id: String) {
        _navigateToDetailClass.value = id
    }

    fun onChapterDetailNavigated() {
        _navigateToDetailClass.value = null
    }
}