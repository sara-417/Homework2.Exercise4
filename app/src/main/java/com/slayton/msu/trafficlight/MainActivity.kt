package com.slayton.msu.trafficlight

import android.content.res.ColorStateList
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.slayton.msu.trafficlight.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private var numberOfButtonClicks = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.trafficButton.setOnClickListener{
            numberOfButtonClicks++
            changeButton(numberOfButtonClicks)
        }
        changeButton(numberOfButtonClicks)
    }

    private fun changeButton (clickNumber: Int) {
       var clickIndex = clickNumber % 3

        if (clickIndex == 0) {
//            button color red
            binding.trafficButton.setText(R.string.button_stop)
            // i got this line from chatGPT
            binding.trafficButton.backgroundTintList = ColorStateList.valueOf(
                ContextCompat.getColor(this, R.color.red))
        }
        else if (clickIndex == 1) {
//            button color green
            binding.trafficButton.setText(R.string.button_go)
            // i got this line from chatGPT
            binding.trafficButton.backgroundTintList = ColorStateList.valueOf(
                ContextCompat.getColor(this, R.color.green))
        }
        else {
//            button color yellow
            binding.trafficButton.setText(R.string.button_wait)
            // i got this line from chatGPT
            binding.trafficButton.backgroundTintList = ColorStateList.valueOf(
                ContextCompat.getColor(this, R.color.yellow))
        }
    }
}

