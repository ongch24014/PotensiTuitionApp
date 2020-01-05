package com.example.potensituitionapp.teacherdetailclass


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders

import com.example.potensituitionapp.R
import com.example.potensituitionapp.database.Timetable
import com.example.potensituitionapp.database.TuitionDatabase
import com.example.potensituitionapp.databinding.FragmentTeacherclassBinding
import com.example.potensituitionapp.databinding.FragmentTeacherdetailclassBinding
import com.example.potensituitionapp.teacherpage.TeacherdetailclassViewModel

/**
 * A simple [Fragment] subclass.
 */
class TeacherdetailclassFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentTeacherdetailclassBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_teacherdetailclass, container, false)

        val arguments = TeacherdetailclassFragmentArgs.fromBundle(arguments)
        val classid:String = arguments.classid

        val application = requireNotNull(this.activity).application
        val dataSource = TuitionDatabase.getInstance(application).timetableDatabaseDao
        val viewModelFactory = TeacherdetailclassViewModelFactory(dataSource, application,classid)

        val teacherdetailclassViewModel =
            ViewModelProviders.of(
                this, viewModelFactory).get(TeacherdetailclassViewModel::class.java)

        val adapter = TeacherdetailclassAdapter()
        binding.studentList.adapter = adapter

        teacherdetailclassViewModel.students.observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.data = it
            }
        })


        val c : Timetable? = dataSource.getTimetable(classid)

        binding.lblTitle.text = c?.className
        binding.lblDay.text = c?.classDay
        binding.lblVenue.text = c?.classVenue
        binding.lblTime.text = c?.classTime.toString()

        binding.btnCancel.setOnClickListener {
            dataSource.delete(classid)

            Toast.makeText(activity, "Class deleted!", Toast.LENGTH_SHORT).show()

        }





        return binding.root
    }


}
