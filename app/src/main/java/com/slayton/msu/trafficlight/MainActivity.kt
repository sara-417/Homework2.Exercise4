package com.slayton.msu.trafficlight

import android.content.res.ColorStateList
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
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
            changeButtonAndImage(numberOfButtonClicks)
        }
        changeButtonAndImage(numberOfButtonClicks)
    }

    private fun changeButtonAndImage (clickNumber: Int) {
       var clickIndex = clickNumber % 3

        if (clickIndex == 0) {
//            button color red
            binding.trafficButton.setText(R.string.button_stop)
            // i got this line from chatGPT
            binding.trafficButton.backgroundTintList = ColorStateList.valueOf(
                ContextCompat.getColor(this, R.color.red))
            binding.redlightView.visibility= View.VISIBLE
            binding.greenlightView.visibility= View.INVISIBLE
            binding.yellowlightView.visibility= View.INVISIBLE
        }
        else if (clickIndex == 1) {
//            button color green
            binding.trafficButton.setText(R.string.button_go)
            // i got this line from chatGPT
            binding.trafficButton.backgroundTintList = ColorStateList.valueOf(
                ContextCompat.getColor(this, R.color.green))
            binding.redlightView.visibility= View.INVISIBLE
            binding.greenlightView.visibility= View.VISIBLE
            binding.yellowlightView.visibility= View.INVISIBLE
        }
        else {
//            button color yellow
            binding.trafficButton.setText(R.string.button_wait)
            // i got this line from chatGPT
            binding.trafficButton.backgroundTintList = ColorStateList.valueOf(
                ContextCompat.getColor(this, R.color.yellow))
            binding.redlightView.visibility= View.INVISIBLE
            binding.greenlightView.visibility= View.INVISIBLE
            binding.yellowlightView.visibility= View.VISIBLE
        }
    }
}

