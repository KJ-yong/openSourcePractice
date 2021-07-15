package com.example.opensourcepractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.opensourcepractice.databinding.ActivityStopwatchBinding

class StopwatchActivity : AppCompatActivity() {
    lateinit var binding : ActivityStopwatchBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_stopwatch)
    }
}