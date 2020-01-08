package com.example.potensituitionapp.attendance

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.potensituitionapp.MainActivity.Companion.loggedUser
import com.example.potensituitionapp.R
import com.example.potensituitionapp.database.ClassRecord
import com.example.potensituitionapp.database.Timetable
import com.example.potensituitionapp.database.TuitionDatabase
import com.example.potensituitionapp.databinding.FragmentAttendanceBinding
import com.example.potensituitionapp.databinding.FragmentAttendanceTeacherBinding
import kotlinx.android.synthetic.main.fragment_attendance_teacher.*
import java.util.*

class AttendanceTeacherFragment(): Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val binding: FragmentAttendanceTeacherBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_attendance_teacher, container, false)

        val application = requireNotNull(this.activity).application
        val dataSource = TuitionDatabase.getInstance(application).classRecordDatabaseDao
        RandomCode()

        fun codeGenerated(){
            binding.btnGenerate.setEnabled(false)
            binding.btnGenerate.setBackgroundResource(R.drawable.button_disabled)
        }

        var sCalendar: Calendar = Calendar.getInstance()

        var sToday:String = sCalendar.getDisplayName(Calendar.DAY_OF_WEEK,Calendar.LONG,Locale.getDefault())

        var todayClass: Timetable = dataSource.getCurrentClass(loggedUser,sToday)

        if(todayClass == null){
            binding.txtName.text = "No class today!"
            binding.txtCode.visibility = View.GONE
            binding.txtRoom.visibility = View.GONE
            binding.txtTime.visibility = View.GONE

            codeGenerated()
        }

        else{
            binding.txtName.text = todayClass.className
            binding.txtRoom.text = todayClass.classVenue
            binding.txtTime.text = todayClass.classTime

            var attend: ClassRecord = dataSource.getRecord(todayClass.classDay,todayClass.classID)

            if(attend == null){

                binding.btnGenerate.setOnClickListener {

                    var cr:ClassRecord = ClassRecord()

                    cr.classDate = todayClass.classDay
                    cr.classID = todayClass.classID
                    cr.attendanceCode =  (0..9999).random().toString()

                    dataSource.insert(cr)

                    binding.txtCode.text = cr.attendanceCode
                    binding.txtCode.visibility = View.VISIBLE
                    codeGenerated()
                }

            }

            else{

                Log.i("ad",attend.attendanceCode)

                binding.txtCode.visibility = View.VISIBLE
                binding.txtCode.text = attend.attendanceCode

                codeGenerated()
            }

        }

        return binding.root



    }

    fun RandomCode(){
        val classCode = "" + ((Math.random() * 9000).toInt() + 1000)
    }


}