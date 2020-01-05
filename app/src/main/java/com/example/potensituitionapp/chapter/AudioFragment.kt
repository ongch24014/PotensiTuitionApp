package com.example.potensituitionapp.chapter


import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import androidx.databinding.DataBindingUtil
import com.example.potensituitionapp.MainActivity

import com.example.potensituitionapp.R
import com.example.potensituitionapp.databinding.FragmentAudioBinding
import kotlinx.android.synthetic.main.fragment_audio.*
import java.util.concurrent.TimeUnit

/**
 * A simple [Fragment] subclass.
 */
class AudioFragment : Fragment() {

    var stopped:Boolean = false
    private lateinit var mp:MediaPlayer
    private lateinit var runnable: Runnable
    private var handler:Handler = Handler()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentAudioBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_audio, container, false
        )

        val arguments = AudioFragmentArgs.fromBundle(arguments)

        val audiopath:String = arguments.audiopath

        var aud_id:Int = resources.getIdentifier(audiopath,"raw",context!!.packageName)

        mp = MediaPlayer.create(context!!,aud_id)

        val conv:Long = mp.duration.toLong()

        val minutes = conv / 1000 / 60
        val seconds = conv / 1000 % 60

        binding.txtDuration.text = minutes.toString() + ":" + seconds.toString()

        binding.btnPlay.setOnClickListener{

            if(stopped == false) {
                mp.start()

                initializeSeekBar()
            }
            else{
                mp = MediaPlayer.create(context!!,aud_id)
                mp.start()
                stopped = true
            }
        }

        binding.btnPause.setOnClickListener{
            mp.pause()
            stopped = false
        }

        binding.btnStop.setOnClickListener{
            mp.stop()
            mp.reset()
            mp.release()
            stopped = true
            binding.seekBar.setProgress(0)
            handler.removeCallbacks(runnable)
        }

        binding.btnSkipNext.setOnClickListener{
            mp.seekTo(mp.currentPosition + 10000)
            mp.start()
        }

        binding.btnSkipPrevious.setOnClickListener{
            mp.seekTo(mp.currentPosition - 10000)
            mp.start()
        }

        binding.seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, i: Int, b: Boolean) {
                if (b) {
                    mp.seekTo(i * 1000)
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
            }
        })



        return binding.root

    }

    private fun initializeSeekBar(){
        seekBar.max = mp.seconds

        runnable = Runnable {
            seekBar.progress = mp.currentSeconds

//            txtDuration.text = mp.currentPosition.toString()
//            val diff = mp.seconds - mp.currentSeconds

            handler.postDelayed(runnable, 1000)

        }
        handler.postDelayed(runnable, 1000)
    }



    val MediaPlayer.seconds:Int
        get() {
            return this.duration / 1000
        }

    val MediaPlayer.currentSeconds:Int
        get() {
            return this.currentPosition/1000
        }

}
