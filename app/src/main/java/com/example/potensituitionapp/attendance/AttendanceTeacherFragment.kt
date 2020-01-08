package com.example.potensituitionapp.attendance

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.potensituitionapp.R
import com.example.potensituitionapp.database.TuitionDatabase
import com.example.potensituitionapp.databinding.FragmentAttendanceBinding

class AttendanceTeacherFragment(): Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding: FragmentAttendanceBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_attendance_teacher, container, false)

        val application = requireNotNull(this.activity).application
        val dataSource = TuitionDatabase.getInstance(application).classRecordDatabaseDao
        RandomCode()
        return binding.root
    }

    fun RandomCode(){
        val classCode = "" + ((Math.random() * 9000).toInt() + 1000)
    }
}