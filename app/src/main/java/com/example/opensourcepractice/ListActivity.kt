package com.example.opensourcepractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.opensourcepractice.databinding.ActivityListBinding

class ListActivity : AppCompatActivity() {
    lateinit var binding : ActivityListBinding
    lateinit var adapter: ListAdapter
    lateinit var viewModel : ListViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_list)
        adapter = ListAdapter(this)
        viewModel = ViewModelProvider(this).get(ListViewModel::class.java)
        viewModel.list.observe(this,{
            adapter.setList(it)
            binding.listView.adapter = adapter
        })
        binding.plusButton.setOnClickListener {
            viewModel.addItem(binding.editText.text.toString())
            binding.editText.setText("")
        }
    }
}