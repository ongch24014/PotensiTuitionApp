package com.example.potensituitionapp.Main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.potensituitionapp.MainActivity
import com.example.potensituitionapp.database.TimetableDao

class MainmenuViewModel(val database: TimetableDao,
                        application: Application
) : AndroidViewModel(application) {

    private val _navigateToDetailClass = MutableLiveData<String>()
    val navigateToDetailClass
        get() = _navigateToDetailClass

    val timetables = database.getStudentTimeTable(MainActivity.loggedUser)

    fun onSleepNightClicked(id: String) {
        _navigateToDetailClass.value = id
    }

    fun onSleepDetailNavigated() {
        _navigateToDetailClass.value = null
    }
}



