package com.example.potensituitionapp.teacherpage


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.potensituitionapp.MainActivity
import com.example.potensituitionapp.MainActivity.Companion.loggedUser
import com.example.potensituitionapp.MainActivity.Companion.role

import com.example.potensituitionapp.R
import com.example.potensituitionapp.database.Teacher
import com.example.potensituitionapp.database.TuitionDatabase
import com.example.potensituitionapp.databinding.FragmentTeachermainBinding

/**
 * A simple [Fragment] subclass.
 */
class TeachermainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentTeachermainBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_teachermain, container, false)

        val application = requireNotNull(this.activity).application
        val dataSource = TuitionDatabase.getInstance(application).teacherDatabaseDao

        (activity as AppCompatActivity).supportActionBar?.title = ""


        val teach:Teacher? = dataSource.get(loggedUser)
        binding.txtName.text = teach?.name.toString()




        binding.logoutButton.setOnClickListener {
            loggedUser = ""
            role = ""

            Toast.makeText(activity, R.string.logout_success, Toast.LENGTH_SHORT).show()

            (activity as MainActivity).setNavInvisible()

            this.findNavController().navigate(
                TeachermainFragmentDirections
                    .actionTeachermainFragmentToTitleFragment())

        }

        binding.btnViewClass.setOnClickListener {
            this.findNavController().navigate(
                TeachermainFragmentDirections.actionTeachermainFragmentToTeacherclassFragment()
            )
        }

        binding.btnattendanceT.setOnClickListener{
            this.findNavController().navigate(
                TeachermainFragmentDirections.actionTeachermainFragmentToAttendanceFragment()
            )
        }
        return binding.root
    }
}
