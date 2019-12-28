package com.example.potensituitionapp.register

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import com.example.potensituitionapp.database.Student
import com.example.potensituitionapp.database.StudentDatabaseDao
import com.example.potensituitionapp.formatStudents
import kotlinx.coroutines.*

class RegisterViewModel(val database: StudentDatabaseDao,
                        application: Application) : AndroidViewModel(application){

    private var viewModelJob = Job()

    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    private var newstudent = MutableLiveData<Student?>()

    private val _navigateToMain = MutableLiveData<Boolean>()

    val navigateToMain: LiveData<Boolean>
        get() = _navigateToMain

    private val students = database.getAllStudents()

    val formatStudents = Transformations.map(students) { students ->
        formatStudents(students, application.resources)
    }

     fun insert(student: Student){
         uiScope.launch {
             withContext(Dispatchers.IO) {
                 database.insert(student)

             }
         }
    }

    fun getStud(): Student{
        var stud: Student = Student()
        uiScope.launch {
             var stud: Student? = get()
        }

        return stud
    }

    suspend fun get(): Student{
        return withContext(Dispatchers.IO) {
            var stud = database.getLastStudent()

            stud
        }
    }



    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}