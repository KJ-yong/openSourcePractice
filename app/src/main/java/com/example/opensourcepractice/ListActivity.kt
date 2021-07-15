package com.example.opensourcepractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.opensourcepractice.databinding.ActivityListBinding

class ListActivity : AppCompatActivity() {
    lateinit var binding : ActivityListBinding
    lateinit var adapter: ListAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_list)
        adapter = ListAdapter(this)
    }
}