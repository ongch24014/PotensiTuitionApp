package com.example.potensituitionapp.teachernewclass


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListAdapter
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.potensituitionapp.MainActivity.Companion.loggedUser

import com.example.potensituitionapp.R
import com.example.potensituitionapp.database.Timetable
import com.example.potensituitionapp.database.TuitionDatabase
import com.example.potensituitionapp.databinding.FragmentTeachernewclassBinding

/**
 * A simple [Fragment] subclass.
 */
class TeachernewclassFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentTeachernewclassBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_teachernewclass, container, false)

        val application = requireNotNull(this.activity).application
        val dataSource = TuitionDatabase.getInstance(application).teacherEnrollDatabaseDao
        val dbtime = TuitionDatabase.getInstance(application).timetableDatabaseDao

        var clist: Array<String> = dataSource.getClasses(loggedUser)
        var days:Array<String> = arrayOf("Monday","Tuesday","Wednesday","Thursday","Friday")
        var rooms:Array<String> = arrayOf("Room 1","Room 2","Room 3","Room 4")
        var time:Array<String> = arrayOf("19:00 - 21:00","20:00 - 22:00")

        var adapter = ArrayAdapter(this.context,android.R.layout.simple_list_item_1,clist)
        binding.spinner.adapter = adapter

        var adapterdays = ArrayAdapter(this.context,android.R.layout.simple_list_item_1,days)
        binding.spinnerDay.adapter = adapterdays

        var adapterrooms = ArrayAdapter(this.context,android.R.layout.simple_list_item_1,rooms)
        binding.spinnerRoom.adapter = adapterrooms

        var adaptertime = ArrayAdapter(this.context,android.R.layout.simple_list_item_1,time)
        binding.spinnerTime.adapter = adaptertime

        binding.btnAdd.setOnClickListener {
            var class_name = binding.spinner.selectedItem.toString()
            var class_id = dataSource.getClassId(class_name)
            var class_venue = binding.spinnerRoom.selectedItem.toString()
            var class_time = binding.spinnerTime.selectedItem.toString()
            var class_day = binding.spinnerDay.selectedItem.toString()
            var teacher_id = loggedUser

            var time:Timetable = Timetable()

            time.classID = class_id
            time.classDay = class_day
            time.className = class_name
            time.classTime = class_time
            time.classVenue = class_venue
            time.teacherID = teacher_id

            dbtime.insert(time)

            Toast.makeText(activity, "Successfully added class!", Toast.LENGTH_SHORT).show()

            this.findNavController().navigate(TeachernewclassFragmentDirections
                .actionTeachernewclassFragmentToTeacherclassFragment())

        }

        return binding.root
    }


}
