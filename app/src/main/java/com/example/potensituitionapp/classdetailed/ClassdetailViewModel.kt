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

    private val _navigateToDetailChapter = MutableLiveData<Int>()
    val navigateToDetailChapter
        get() = _navigateToDetailChapter

    val chapters = database.getAllChapter(class_ID)

    fun onChapterDetailClicked(num: Int) {
        _navigateToDetailChapter.value = num
    }

    fun onChapterDetailNavigated() {
        _navigateToDetailChapter.value = null
    }

    fun onChapterClicked(num: Int){
        _navigateToDetailChapter.value = num
    }
}