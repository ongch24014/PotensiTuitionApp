package com.example.potensituitionapp.teacherpage

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.potensituitionapp.MainActivity
import com.example.potensituitionapp.MainActivity.Companion.loggedUser
import com.example.potensituitionapp.database.Timetable
import com.example.potensituitionapp.database.TimetableDao

class TeacherclassViewModel(val database: TimetableDao,
                            application: Application
) : AndroidViewModel(application) {

    private val _navigateToDetailClass = MutableLiveData<Timetable>()
    val navigateToDetailClass
        get() = _navigateToDetailClass

    val teacherclass = database.getTeacherClass(loggedUser)

    fun onClassDetailClicked(id: Timetable) {
        _navigateToDetailClass.value = id
    }

    fun onClassDetailNavigated() {
        _navigateToDetailClass.value = null
    }
}