package com.selbie.mediaplayback

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.SeekBar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.selbie.mediaplayback.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun setControlStates(enablePrev:Boolean, enableNext:Boolean, enablePlayStop:Boolean, isPlaying:Boolean, enableSeekBar:Boolean) {
        binding.prev.isEnabled = enablePrev
        binding.next.isEnabled = enableNext

        if (isPlaying) {
            // show stop button when playing
            binding.play.visibility = View.GONE
            binding.stop.visibility = View.VISIBLE
        } else {
            binding.play.visibility = View.VISIBLE
            binding.stop.visibility = View.GONE
        }

        binding.seekbar.isEnabled = enableSeekBar
    }


    companion object {
        val disabledColor = Color.argb(.5f, 0.0f,0.0f,0.0f)
        val enabledColor = Color.BLACK
        fun getEnableDisableColor(isEnabled:Boolean) : Int {
            return if (isEnabled) enabledColor else disabledColor
        }
    }

}