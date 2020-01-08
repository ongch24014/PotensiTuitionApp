package com.example.potensituitionapp.enrollment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.potensituitionapp.R
import com.example.potensituitionapp.database.TuitionDatabase
import com.example.potensituitionapp.databinding.FragmentEnrollmentBinding
import androidx.lifecycle.Observer
import com.example.potensituitionapp.enrolldetails.EnrolldetailFragment
import java.util.*

class Enrollment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentEnrollmentBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_enrollment,container,false)

        val application =requireNotNull(this.activity).application
        val dataSource = TuitionDatabase.getInstance(application).courseDatabaseDao
        val viewModelFactory = EnrollmentViewModelFactory(dataSource,application )

        val enrollmentViewModel =
            ViewModelProviders.of(
                this, viewModelFactory).get(EnrollmentViewModel::class.java)

        val adapter = EnrollmentCourseAdapter(CourseListener { nightId ->
            Toast.makeText(context, "${nightId}", Toast.LENGTH_LONG).show()

            enrollmentViewModel.onCourseClicked(nightId)
        })

        enrollmentViewModel.navigateToCourse.observe(this, Observer { night ->
            night?.let {
                this.findNavController().navigate(
            EnrollmentDirections.actionEnrollmentToEnrolldetailFragment(night))

            }
        })

        binding.courseList.adapter = adapter

        enrollmentViewModel.courses.observe(viewLifecycleOwner ,androidx.lifecycle.Observer {
            it?.let {
                adapter.submitList(it)
            } })

        return binding.root

    }

}