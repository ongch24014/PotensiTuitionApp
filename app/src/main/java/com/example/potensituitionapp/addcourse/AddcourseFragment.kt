package com.example.potensituitionapp.addcourse


import android.os.Bundle
import android.text.Spanned
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.potensituitionapp.R
import com.example.potensituitionapp.database.Course
import com.example.potensituitionapp.database.TuitionDatabase
import com.example.potensituitionapp.databinding.FragmentAddcourseBinding

/**
 * A simple [Fragment] subclass.
 */
class AddcourseFragment : Fragment() {

    private var courseID : String = ""
    private var courseName : String = ""


    var formatCourses:LiveData<Spanned>? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (activity as AppCompatActivity).supportActionBar?.title = "Add Course"

        val binding: FragmentAddcourseBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_addcourse, container, false)

//Database
        val application = requireNotNull(this.activity).application
        val dataSource = TuitionDatabase.getInstance(application).courseDatabaseDao

        val viewModelFactory = AddcourseViewModelFactory(dataSource, application)
        val addCourseViewModel =
            ViewModelProviders.of(
                this, viewModelFactory).get(AddcourseViewModel::class.java)

        binding.addcourseViewModel = addCourseViewModel

        binding.setLifecycleOwner(this)

        var c:Course? = dataSource.get(1)
        var c1:Course? = dataSource.get(2)
        var c3:Course? = dataSource.get(3)

        Log.i("1",c?.courseID)
        Log.i("2",c1?.courseID)
        Log.i("3",c3?.courseID)




        binding.btnAdd.setOnClickListener{

            courseID = binding.txtCourseID.text.toString()
            courseName = binding.txtCourseName.text.toString()

            var course: Course = Course()

            course.courseID = courseID
            course.courseName = courseName

            dataSource.insert(course)

            Toast.makeText(activity, "Successfully added Course!", Toast.LENGTH_SHORT).show()

        }


        return binding.root
    }


}
