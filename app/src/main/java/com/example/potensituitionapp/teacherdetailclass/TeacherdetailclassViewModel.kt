package com.example.potensituitionapp.teacherpage

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.potensituitionapp.MainActivity
import com.example.potensituitionapp.MainActivity.Companion.loggedUser
import com.example.potensituitionapp.database.TimetableDao

class TeacherdetailclassViewModel(val database: TimetableDao,
                            application: Application
) : AndroidViewModel(application) {

    private val _navigateToDetailClass = MutableLiveData<String>()
    val navigateToDetailClass
        get() = _navigateToDetailClass

    val timetables = database.getTeacherClass(loggedUser)

    fun onClassDetailClicked(id: String) {
        _navigateToDetailClass.value = id
    }

    fun onClassDetailNavigated() {
        _navigateToDetailClass.value = null
    }
}