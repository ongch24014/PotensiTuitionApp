package com.example.potensituitionapp.userprofile


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.potensituitionapp.MainActivity
import com.example.potensituitionapp.MainActivity.Companion.loggedUser
import com.example.potensituitionapp.MainActivity.Companion.user_namename

import com.example.potensituitionapp.R
import com.example.potensituitionapp.database.Student
import com.example.potensituitionapp.databinding.FragmentEnrollmentBinding
import com.example.potensituitionapp.databinding.FragmentStudentprofileBinding
import kotlinx.android.synthetic.main.fragment_teachermain.*

/**
 * A simple [Fragment] subclass.
 */
class StudentprofileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val binding:FragmentStudentprofileBinding= DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_studentprofile, container, false)

        binding.txtName.text = "Welcome, " + user_namename
        binding.txtId.text = "ID : " + loggedUser

        binding.btnEnrollment.setOnClickListener {
            this.findNavController().navigate(
                    StudentprofileFragmentDirections.actionStudentprofileFragment2ToEnrollment()
            )
        }

        binding.logoutButton.setOnClickListener {
            MainActivity.loggedUser = ""
            MainActivity.role = ""
            user_namename = ""

            Toast.makeText(activity, R.string.logout_success, Toast.LENGTH_SHORT).show()

            (activity as MainActivity).setNavInvisible()

            this.findNavController().navigate(
                StudentprofileFragmentDirections.actionStudentprofileFragment2ToLoginFragment())

        }


        return binding.root
    }


}
