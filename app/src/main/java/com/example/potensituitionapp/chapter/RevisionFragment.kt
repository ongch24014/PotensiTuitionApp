package com.example.potensituitionapp.chapter


import android.app.Activity
import android.app.AlarmManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.provider.AlarmClock
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.potensituitionapp.MainActivity
import com.example.potensituitionapp.MainActivity.Companion.loggedUser

import com.example.potensituitionapp.R
import com.example.potensituitionapp.database.Revision
import com.example.potensituitionapp.database.TuitionDatabase
import com.example.potensituitionapp.databinding.FragmentRevisionBinding

/**
 * A simple [Fragment] subclass.
 */
class RevisionFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentRevisionBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_revision, container, false
        )

        val application = requireNotNull(this.activity).application
        val arguments = RevisionFragmentArgs.fromBundle(arguments)
        val dataSource = TuitionDatabase.getInstance(application).revisionDao

        var chapnum:String = arguments.cNum
        var classid = arguments.classId

        Log.i("chap",chapnum)
        Log.i("class",classid)

        var revv = dataSource.get(classid,chapnum,loggedUser)

        if(revv == null){

        }

        else{
            binding.txtText.setText(revv.content)
        }

        binding.btnSave.setOnClickListener {

            this.hideKeyboard()

            var rev = dataSource.get(classid,chapnum,loggedUser)

            var text:String = binding.txtText.text.toString()

            if(rev == null){
                var re: Revision = Revision()

                re.classID = classid
                re.chapNum = chapnum
                re.studID = loggedUser
                re.content = text

                dataSource.insert(re)
                Toast.makeText(activity, "Successfully added! Remember to do revision!", Toast.LENGTH_SHORT).show()
            }

            else{

                rev.content = text

                dataSource.update(rev)

                Toast.makeText(activity, "Successfully updated! Remember to do revision!", Toast.LENGTH_SHORT).show()

            }

            (activity as MainActivity).sendNotification(this.view!!)
        }

        binding.btnReminder.setOnClickListener {
            val i = Intent(AlarmClock.ACTION_SET_ALARM)
            i.putExtra(AlarmClock.EXTRA_MESSAGE, "Do Revision!")
            i.putExtra(AlarmClock.EXTRA_HOUR, 22)
            i.putExtra(AlarmClock.EXTRA_MINUTES, 0)
            startActivity(i)
        }
        return binding.root
    }

    fun Fragment.hideKeyboard() {
        view?.let { activity?.hideKeyboard(it) }
    }

    fun Activity.hideKeyboard() {
        hideKeyboard(currentFocus ?: View(this))
    }

    fun Context.hideKeyboard(view: View) {
        val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }
}


