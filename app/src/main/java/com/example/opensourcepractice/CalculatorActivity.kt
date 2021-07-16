package com.example.opensourcepractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.opensourcepractice.databinding.ActivityCalculatorBinding

class CalculatorActivity : AppCompatActivity() {
    lateinit var binding : ActivityCalculatorBinding
    lateinit var viewModel: CalculViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_calculator)
        binding.activity = this@CalculatorActivity
        viewModel = ViewModelProvider(this).get(CalculViewModel::class.java)
        viewModel.answer.observe(this,{
            binding.answer.text = it
        })
        viewModel.expression.observe(this,{
            binding.expression.text = it
        })
        binding.buttonClear.setOnClickListener {
            viewModel.inputClear()
        }
        binding.buttonEqual.setOnClickListener {
            viewModel.inputEqual()
        }
    }
    fun clickNumber(view : View){
        val button = view as Button
        viewModel.inputNumber(button.text as String)
    }
    fun clickOperator(view : View){
        val button = view as Button
        viewModel.inputOperator(button.text as String)
    }
}