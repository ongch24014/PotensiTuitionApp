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
import com.example.potensituitionapp.MainActivity.Companion.role
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
            if(role.equals("Student")){
                (activity as MainActivity).setNavVisible()
                findNavController().navigate(R.id.mainmenuFragment)
            }

            else if(role.equals("Teacher")){
                (activity as MainActivity).setNavInvisible()
                findNavController().navigate(R.id.teachermainFragment)
            }

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
        val teacherdb = TuitionDatabase.getInstance(application).teacherDatabaseDao
        val teacherenrolldb = TuitionDatabase.getInstance(application).teacherEnrollDatabaseDao


        userdb.insert(Student(1,"S001","user","123"))

        enrolldb.insert(Enrollment(1,"S001","C001","1"))
        enrolldb.insert(Enrollment(2,"S001","C002","1"))
        enrolldb.insert(Enrollment(3,"S001","C003","1"))
        enrolldb.insert(Enrollment(4,"S001","C004","1"))
        enrolldb.insert(Enrollment(5,"S001","C005","1"))

        timetabledb.insert(Timetable(1,"C001","Biology","Room 1",1,"Monday","T001"))
        timetabledb.insert(Timetable(2,"C002","Chemistry","Room 2",1,"Tuesday","T001"))
        timetabledb.insert(Timetable(3,"C003","Physics","Room 3",1,"Wednesday","T003"))
        timetabledb.insert(Timetable(4,"C004","English","Room 3",1,"Thursday","T004"))
        timetabledb.insert(Timetable(5,"C005","Chinese","Room 3",1,"Friday","T005"))

        chapterdb.insert(Chapter(1,"C001",1,"Life"))
        chapterdb.insert(Chapter(2,"C001",2,"Human Life"))
        chapterdb.insert(Chapter(3,"C001",3,"Organs"))

        teacherdb.insert(Teacher(1,"T001","ongch","123","012-4726059","ocheng.90@gmail.com"))
        teacherdb.insert(Teacher(2,"T002","teacher","123","012-4999959","999.90@gmail.com"))

        teacherenrolldb.insert(TeacherEnroll(1,"T001","C001","Biology"))
        teacherenrolldb.insert(TeacherEnroll(2,"T001","C002","Chemistry"))
    }



}
