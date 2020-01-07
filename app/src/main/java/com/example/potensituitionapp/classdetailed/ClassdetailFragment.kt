package com.example.potensituitionapp.classdetailed


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.potensituitionapp.Main.MainmenuFragment
import com.example.potensituitionapp.Main.MainmenuFragmentDirections

import com.example.potensituitionapp.R
import com.example.potensituitionapp.database.Timetable
import com.example.potensituitionapp.database.TuitionDatabase
import com.example.potensituitionapp.databinding.FragmentClassdetailBinding
import kotlinx.android.synthetic.main.fragment_classdetail.*

/**
 * A simple [Fragment] subclass.
 */
class ClassdetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentClassdetailBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_classdetail, container, false
        )

        (activity as AppCompatActivity).supportActionBar?.title = "Chapters"

        val application = requireNotNull(this.activity).application
        val arguments = ClassdetailFragmentArgs.fromBundle(arguments)
        val class_ID = arguments.classId

        val dataSource = TuitionDatabase.getInstance(application).chapterDatabaseDao
        val ds = TuitionDatabase.getInstance(application).timetableDatabaseDao

        val clasname = ds.getSpecificTimetable(class_ID)

        val viewModelFactory = ClassdetailViewModelFactory(class_ID, dataSource, application)

        val classdetailViewModel =
            ViewModelProviders.of(
                this, viewModelFactory
            ).get(ClassdetailViewModel::class.java)


        val adapter = ClassdetailAdapter(ChapterListener { classNum ->
            Toast.makeText(context, "${classNum}", Toast.LENGTH_LONG).show()
            classdetailViewModel.onChapterClicked(classNum)
        })

        classdetailViewModel.chapters.observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.submitList(it)
            }
        })

        classdetailViewModel.navigateToDetailChapter.observe(this, Observer { night ->
            night?.let {
                this.findNavController().navigate(ClassdetailFragmentDirections.actionClassdetailFragmentToChapterFragment(night,class_ID))
                classdetailViewModel.onChapterDetailNavigated()
            }
        })

        binding.chapterList.adapter = adapter


        Log.i("s", class_ID)

        binding.className.text = class_ID

        return binding.root


    }
}

