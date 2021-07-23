package com.decadev.aboutme

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.decadev.aboutme.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_second)

        setListeners()

    }

    fun setListeners() {
        val clickableViews: List<View> = listOf(
            binding.boxOne,
            binding.boxTwo,
            binding.boxThree,
            binding.boxFour,
            binding.boxFive,
            binding.yellowButton,
            binding.redButton,
            binding.greenButton
        )

        for (item in clickableViews) {
            item.setOnClickListener { makeColoured(it) }
        }
    }


    fun makeColoured(view: View) {
        when (view.id) {
            // Boxes using Color class colors for background
            R.id.box_one -> view.setBackgroundColor(Color.DKGRAY)
            R.id.box_two -> view.setBackgroundColor(Color.GRAY)

            // Boxes using Android color resources for background
            R.id.box_three -> view.setBackgroundResource(android.R.color.holo_red_dark)
            R.id.box_four -> view.setBackgroundResource(android.R.color.holo_blue_dark)
            R.id.box_five -> view.setBackgroundResource(android.R.color.holo_blue_bright)

            // Boxes using custom colors for background
            R.id.red_button -> binding.boxThree.setBackgroundResource(R.color.black)
            R.id.yellow_button -> binding.boxFour.setBackgroundResource(R.color.teal_700)
            R.id.green_button -> binding.boxFive.setBackgroundResource(R.color.purple_700)

            else -> view.setBackgroundColor(Color.LTGRAY)
        }

    }
}