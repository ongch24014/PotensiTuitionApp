package com.example.potensituitionapp.timetable

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.potensituitionapp.database.TimetableDao
import com.example.potensituitionapp.MainActivity.Companion.loggedUser

class TimetableViewModel(
    val database: TimetableDao,
    application: Application
) : AndroidViewModel(application) {

    val mon:String = "Monday"
    val tues:String = "Tuesday"
    val wed:String = "Wednesday"
    val thurs:String = "Thursday"
    val fri:String = "Friday"

    val timetables = database.getStudentTimeTable(loggedUser)

    val timetablesMon = database.getStudentTimeTableMonday(loggedUser,mon)

    val timetablesTues = database.getStudentTimeTableTuesday(loggedUser,tues)

    val timetablesWed = database.getStudentTimeTableWednesday(loggedUser,wed)

    val timetablesThurs = database.getStudentTimeTableThursday(loggedUser,thurs)

    val timetablesFri = database.getStudentTimeTableFriday(loggedUser,fri)

}