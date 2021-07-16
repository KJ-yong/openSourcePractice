package com.example.opensourcepractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.example.opensourcepractice.databinding.ActivityStopwatchBinding

class StopwatchActivity : AppCompatActivity() {
    lateinit var binding : ActivityStopwatchBinding
    lateinit var viewModel: StopwatchViewModel
    private var adapter = StopwatchRecordAdapter(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_stopwatch)
        binding.recyclerView.adapter = adapter
        viewModel = ViewModelProvider(this).get(StopwatchViewModel::class.java)
        viewModel.time.observe(this,{
            binding.textTime.text = it
        })
        viewModel.recordList.observe(this,{
            adapter.setData(it)
        })
        binding.btnStart.setOnClickListener {
            viewModel.startTimer()
        }
        binding.btnStop.setOnClickListener {
            viewModel.stopTimer()
            viewModel.clear()
        }
        binding.btnPause.setOnClickListener {
            viewModel.stopTimer()
        }
    }
}