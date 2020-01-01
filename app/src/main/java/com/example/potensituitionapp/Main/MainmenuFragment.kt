package com.example.potensituitionapp.Main


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.potensituitionapp.MainActivity
import com.example.potensituitionapp.MainActivity.Companion.loggedUser

import com.example.potensituitionapp.R
import com.example.potensituitionapp.database.TuitionDatabase
import com.example.potensituitionapp.databinding.FragmentMainmenuBinding
import kotlin.math.log

/**
 * A simple [Fragment] subclass.
 */
class MainmenuFragment : Fragment() {

    companion object {
        fun newInstance(): MainmenuFragment = MainmenuFragment()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        (activity as AppCompatActivity).supportActionBar?.title = "Main Menu"

        val binding: FragmentMainmenuBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_mainmenu, container, false)

        //Database
        val application = requireNotNull(this.activity).application
        val dataSource = TuitionDatabase.getInstance(application).studentDatabaseDao

        binding.txtUser.text = "Welcome : " + loggedUser

        binding.LogoutButton.setOnClickListener{
            loggedUser = ""
            Toast.makeText(activity, R.string.logout_success, Toast.LENGTH_SHORT).show()

            (activity as MainActivity).setNavInvisible()


            this.findNavController().navigate(
                MainmenuFragmentDirections
                    .actionMainmenuFragmentToTitleFragment())
        }

        binding.AddCourseButton.setOnClickListener{view: View -> view.findNavController().navigate(
            MainmenuFragmentDirections.actionMainmenuFragmentToAddcourseFragment2()
        )
        }


        return binding.root
    }


}
