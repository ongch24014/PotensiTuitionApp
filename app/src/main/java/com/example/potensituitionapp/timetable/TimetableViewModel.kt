package com.example.potensituitionapp.timetable

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.potensituitionapp.database.TimetableDao
import com.example.potensituitionapp.MainActivity.Companion.loggedUser

class TimetableViewModel(
    val database: TimetableDao,
    application: Application
) : AndroidViewModel(application) {

    val timetables = database.getStudentTimeTable(loggedUser)


}