package com.example.potensituitionapp


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.potensituitionapp.databinding.FragmentTitleBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.example.potensituitionapp.MainActivity.Companion.loggedUser
import com.example.potensituitionapp.database.*

/**
 * A simple [Fragment] subclass.
 */
class TitleFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {


        val binding = DataBindingUtil.inflate<FragmentTitleBinding>(inflater,
            R.layout.fragment_title,container,false)

        binding.loginButton.setOnClickListener{view : View ->

            view.findNavController().navigate(TitleFragmentDirections.actionTitleFragmentToLoginFragment())}

        binding.RegisterButton.setOnClickListener{view : View ->

            view.findNavController().navigate(TitleFragmentDirections.actionTitleFragmentToRegisterFragment())}

        (activity as AppCompatActivity).supportActionBar?.title = "Potensi Tuition App"


        (activity as MainActivity).setNavInvisible()


        if(loggedUser.equals("")){
            (activity as MainActivity).setNavInvisible()
        }
        else{
            (activity as MainActivity).setNavVisible()
            findNavController().navigate(R.id.mainmenuFragment)
        }

        binding.addData.setOnClickListener{
            addDatabase()
        }

        return binding.root
    }

    fun addDatabase(){
        val application = requireNotNull(this.activity).application

        val chapterdb = TuitionDatabase.getInstance(application).chapterDatabaseDao
        val userdb = TuitionDatabase.getInstance(application).studentDatabaseDao
        val enrolldb = TuitionDatabase.getInstance(application).enrollmentDatabaseDao
        val timetabledb = TuitionDatabase.getInstance(application).timetableDatabaseDao


        userdb.insert(Student(1,"S001","user","123"))

        enrolldb.insert(Enrollment(1,"S001","C001","1"))
        enrolldb.insert(Enrollment(2,"S001","C002","1"))
        enrolldb.insert(Enrollment(3,"S001","C003","1"))
        enrolldb.insert(Enrollment(4,"S001","C004","1"))
        enrolldb.insert(Enrollment(5,"S001","C005","1"))

        timetabledb.insert(Timetable(1,"C001","Biology","Room 1",1,"Monday"))
        timetabledb.insert(Timetable(2,"C002","Chemistry","Room 2",1,"Tuesday"))
        timetabledb.insert(Timetable(3,"C003","Physics","Room 3",1,"Wednesday"))
        timetabledb.insert(Timetable(4,"C004","English","Room 3",1,"Thursday"))
        timetabledb.insert(Timetable(5,"C005","Chinese","Room 3",1,"Friday"))

        chapterdb.insert(Chapter(1,"C001",1,"Life"))
        chapterdb.insert(Chapter(2,"C001",2,"Human Life"))
        chapterdb.insert(Chapter(3,"C001",3,"Organs"))
    }



}
