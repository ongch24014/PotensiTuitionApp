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

        (activity as AppCompatActivity).supportActionBar?.title = "Potensi Tuition App"


        (activity as MainActivity).setNavInvisible()

        val application = requireNotNull(this.activity).application
        val userdb = TuitionDatabase.getInstance(application).studentDatabaseDao


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

        var find = userdb.getALL()

        if(find == null){
            binding.addData.setEnabled(true)
            binding.addData.visibility = View.VISIBLE
        }

        else{
            binding.addData.setEnabled(false)
            binding.addData.visibility = View.GONE
        }


        binding.addData.setOnClickListener{
            addDatabase()
            binding.addData.setEnabled(false)
            binding.addData.visibility = View.GONE
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
        val coursedb = TuitionDatabase.getInstance(application).courseDatabaseDao


        userdb.insert(Student(1,"S001","Ong Chun Heng","123"))
        userdb.insert(Student(2,"S002","Wong Chang Hong","123"))
        userdb.insert(Student(3,"S003","Wong Qi Lun","123"))
        userdb.insert(Student(4,"S004","Chang Kok Fee","123"))

        enrolldb.insert(Enrollment(1,"S001","C001","Biology"))
        enrolldb.insert(Enrollment(2,"S001","C002","Chemistry"))
        enrolldb.insert(Enrollment(3,"S001","C003","Physics"))
        enrolldb.insert(Enrollment(4,"S001","C004","English"))
        enrolldb.insert(Enrollment(5,"S001","C005","Chinese"))
        enrolldb.insert(Enrollment(6,"S002","C001","Biology"))
        enrolldb.insert(Enrollment(7,"S002","C003","Physics"))
        enrolldb.insert(Enrollment(8,"S003","C004","English"))
        enrolldb.insert(Enrollment(9,"S003","C005","Chinese"))
        enrolldb.insert(Enrollment(10,"S004","C002","Chemistry"))

        timetabledb.insert(Timetable(1,"C001","Biology","Room 1","19:00 - 21:00","Monday","T001"))
        timetabledb.insert(Timetable(2,"C002","Chemistry","Room 2","19:00 - 21:00","Tuesday","T001"))
        timetabledb.insert(Timetable(3,"C003","Physics","Room 3","20:00 - 22:00","Wednesday","T003"))
        timetabledb.insert(Timetable(4,"C004","English","Room 3","20:00 - 22:00","Thursday","T004"))
        timetabledb.insert(Timetable(5,"C005","Chinese","Room 3","20:00 - 22:00","Friday","T005"))

        chapterdb.insert(Chapter(1,"C001",1,"Life","bio_chap1","bio_chap1"))
        chapterdb.insert(Chapter(2,"C001",2,"Human Life","","bio_chap2"))
        chapterdb.insert(Chapter(3,"C001",3,"Organs","","bio_chap3"))

        chapterdb.insert(Chapter(4,"C002",1,"Introduction to Chemistry","",""))
        chapterdb.insert(Chapter(5,"C002",2,"The Structure of the Atom","",""))
        chapterdb.insert(Chapter(6,"C002",3,"Chemical Formulae and Equations","",""))

        chapterdb.insert(Chapter(7,"C003",1,"Introduction to Physics","",""))
        chapterdb.insert(Chapter(8,"C003",2,"Forces and Motion","",""))
        chapterdb.insert(Chapter(9,"C003",3,"Forces and Pressure","",""))

        chapterdb.insert(Chapter(10,"C004",1,"People Social Issue","",""))
        chapterdb.insert(Chapter(11,"C004",2,"People","",""))
        chapterdb.insert(Chapter(12,"C004",3,"Environment","",""))

        chapterdb.insert(Chapter(13,"C005",1,"Introduction of Chinese","",""))
        chapterdb.insert(Chapter(14,"C005",2,"Chinese history","",""))
        chapterdb.insert(Chapter(15,"C005",3,"Chinese culture","",""))


        teacherdb.insert(Teacher(1,"T001","Mr Ong","123","012-4726059","ocheng.90@gmail.com"))
        teacherdb.insert(Teacher(2,"T002","Mr Lee","123","012-4999959","999.90@gmail.com"))
        teacherdb.insert(Teacher(3,"T003","Mr Wong","123","012-4999959","999.90@gmail.com"))
        teacherdb.insert(Teacher(4,"T002","Mr Wong","123","012-4999959","999.90@gmail.com"))

        teacherenrolldb.insert(TeacherEnroll(1,"T001","C001","Biology"))
        teacherenrolldb.insert(TeacherEnroll(2,"T001","C002","Chemistry"))
        teacherenrolldb.insert(TeacherEnroll(3,"T002","C003","Physics"))
        teacherenrolldb.insert(TeacherEnroll(4,"T003","C004","English"))
        teacherenrolldb.insert(TeacherEnroll(5,"T004","C005","Chinese"))

        coursedb.insert(Course(1,"C001","Biology","Learn some life changing organism",100.0))
        coursedb.insert(Course(2,"C002","Chemistry","Mix some chemicals up, its fun!",100.0))
        coursedb.insert(Course(3,"C003","Physics","Be the next Albert Einstein",200.0))
        coursedb.insert(Course(4,"C004","English","Learn some American slang here!",100.0))
        coursedb.insert(Course(5,"C005","Chinese","Learn how to say GongXiFaCai",200.0))


    }



}
