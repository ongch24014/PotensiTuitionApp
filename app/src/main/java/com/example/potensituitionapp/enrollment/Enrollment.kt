package com.example.potensituitionapp.enrollment

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.potensituitionapp.R
import com.example.potensituitionapp.database.TuitionDatabase
import com.example.potensituitionapp.databinding.FragmentEnrollmentBinding
import com.example.potensituitionapp.timetable.TimetableViewModel
import java.util.*

class Enrollment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentEnrollmentBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_enrollment,container,false)

        val adapter =EnrollmentCourseAdapter()
        val application =requireNotNull(this.activity).application
        val dataSource = TuitionDatabase.getInstance(application).courseDatabaseDao
        val viewModelFactory = EnrollmentViewModelFactory(dataSource,application )
        binding.courseList.adapter = adapter
        val EnrollmentViewModel =
            ViewModelProviders.of(
                this, viewModelFactory).get(EnrollmentViewModel::class.java)
        EnrollmentViewModel.courses.observe(viewLifecycleOwner ,androidx.lifecycle.Observer {
            it?.let {
                adapter.data = it
            } })

        return binding.root

    }

}