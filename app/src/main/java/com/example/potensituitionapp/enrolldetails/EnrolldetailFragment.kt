package com.example.potensituitionapp.enrolldetails


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.potensituitionapp.MainActivity.Companion.loggedUser

import com.example.potensituitionapp.R
import com.example.potensituitionapp.database.Course
import com.example.potensituitionapp.database.Enrollment
import com.example.potensituitionapp.database.TuitionDatabase
import com.example.potensituitionapp.databinding.FragmentEnrolldetailBinding
import java.util.*

/**
 * A simple [Fragment] subclass.
 */
class EnrolldetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentEnrolldetailBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_enrolldetail, container, false
        )

        val arguments = EnrolldetailFragmentArgs.fromBundle(arguments)
        val class_id = arguments.courseId

        val application = requireNotNull(this.activity).application
        val dataSource = TuitionDatabase.getInstance(application).courseDatabaseDao

        val ccourse: Course = dataSource.getCourse(class_id)

        binding.txtName.text = ccourse.courseName
        binding.txtDesc.text = ccourse.courseDescripton
        binding.txtPrice.text = "RM " + ccourse.coursePrice.toString()

        val eenrol:Enrollment? = dataSource.getEnroll(class_id, loggedUser)

        if(eenrol == null){
            binding.btnEnroll.setEnabled(true)
        }
        else{
            binding.btnEnroll.setEnabled(false)
            binding.btnEnroll.setBackgroundResource(R.drawable.button_disabled)
        }

        binding.btnEnroll.setOnClickListener {
            var enrollment:Enrollment = Enrollment()

            enrollment.classID = class_id
            enrollment.className = ccourse.courseName
            enrollment.studentID = loggedUser
            enrollment.enrollmentDate = "11/01/2020"

            dataSource.insertEnroll(enrollment)
            Toast.makeText(context, "Enroll Successful!", Toast.LENGTH_LONG).show()

            this.findNavController()
                .navigate(
                    EnrolldetailFragmentDirections.actionEnrolldetailFragmentToMainmenuFragment()
                )
        }





        return binding.root
    }


}
