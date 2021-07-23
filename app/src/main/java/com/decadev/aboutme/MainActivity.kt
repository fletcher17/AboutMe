package com.decadev.aboutme

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import com.decadev.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)


        binding.doneButton.setOnClickListener {
            addNickName(it)
        }

        binding.nextActivityButton.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }

        Log.i("MainActivity", "This is onCreate")
    }

    fun addNickName(view: View) {
        binding.apply {
            nickNameTextView.text = binding.nicknameEdit.text
            invalidateAll()
            nicknameEdit.isVisible = false
            nickNameTextView.visibility = View.VISIBLE
            doneButton.visibility = View.GONE
        }

        // To Hide the keyboard.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)

    }


    override fun onStart() {
        super.onStart()
        Log.i("MainActivity", "this is on start")
    }

    override fun onResume() {
        super.onResume()
        Log.i("Main", "This is on Resume")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("Main", "This is on Destroy")
    }

    override fun onPause() {
        super.onPause()
        Log.i("Main", "This is on Pause")
    }

    override fun onStop() {
        super.onStop()
        Log.i("Main", "This is on Stop")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("Main", "This is on Restart")
    }
}