package com.example.potensituitionapp.Main


import android.os.Bundle
import android.os.Handler
import android.view.KeyEvent
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
import android.view.KeyEvent.KEYCODE_BACK
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.GridLayoutManager
import com.example.potensituitionapp.attendance.AttendanceFragment
import com.example.potensituitionapp.timetable.TimetableAdapter


/**
 * A simple [Fragment] subclass.
 */
class MainmenuFragment : Fragment() {

    private var doubleBackToExitPressedOnce = false

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
        val dataSource1 = TuitionDatabase.getInstance(application).timetableDatabaseDao
        val viewModelFactory = MainmenuViewModelFactory(dataSource1, application)


        val mainmenuViewModel =
            ViewModelProviders.of(
                this, viewModelFactory).get(MainmenuViewModel::class.java)

        val adapter = MainmenuAdapter(TimetableListener { classId ->
            Toast.makeText(context,"${classId}",Toast.LENGTH_LONG).show()
            mainmenuViewModel.onClassDetailClicked(classId)
        })

        mainmenuViewModel.timetables.observe(viewLifecycleOwner, Observer{
            mainmenuViewModel.timetables.observe(viewLifecycleOwner, Observer {
                it?.let {
                    adapter.submitList(it)

                }
            })
        })

        binding.timetableList.adapter = adapter

        binding.txtUser.text = "Welcome : " + loggedUser

        binding.btnAttendance.setOnClickListener(){
            findNavController().navigate(MainmenuFragmentDirections.actionMainmenuFragmentToAttendanceFragment2())
        }

        binding.LogoutButton.setOnClickListener{
            loggedUser = ""
            Toast.makeText(activity, R.string.logout_success, Toast.LENGTH_SHORT).show()

            (activity as MainActivity).setNavInvisible()

            this.findNavController().navigate(
                MainmenuFragmentDirections
                    .actionMainmenuFragmentToTitleFragment())
        }

        mainmenuViewModel.navigateToDetailClass.observe(this, Observer { night ->
            night?.let {
                this.findNavController().navigate(
                    MainmenuFragmentDirections
                        .actionMainmenuFragmentToClassdetailFragment(night))
                mainmenuViewModel.onClassDetailNavigated()
            }
        })


        val manager = GridLayoutManager(activity, 2)

        binding.timetableList.layoutManager = manager

        return binding.root
    }

    override//Pressed return button - returns to the results menu
    fun onResume() {
        super.onResume()
        view!!.isFocusableInTouchMode = true
        view!!.requestFocus()
        view!!.setOnKeyListener(object : View.OnKeyListener {
            override fun onKey(v: View, keyCode: Int, event: KeyEvent): Boolean {
                return if (event.getAction() === KeyEvent.ACTION_UP && keyCode == KeyEvent.KEYCODE_BACK) {
                    if (doubleBackToExitPressedOnce) {
                        loggedUser=""
                        findNavController().navigate(MainmenuFragmentDirections.actionMainmenuFragmentToTitleFragment())
                        return true
                    }

                    doubleBackToExitPressedOnce = true
                    Toast.makeText(context, "Please click BACK again to exit", Toast.LENGTH_SHORT).show()

                    Handler().postDelayed(Runnable { doubleBackToExitPressedOnce = false }, 2000)

                    true
                } else false
            }
        })
    }


}
