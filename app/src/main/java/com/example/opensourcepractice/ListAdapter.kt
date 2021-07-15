package com.example.opensourcepractice

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.example.opensourcepractice.databinding.ListViewBinding

class ListAdapter (private val context : Context) : BaseAdapter(){
    private var list = arrayListOf<String>()
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val binding = ListViewBinding.inflate(LayoutInflater.from(context),parent,false)
        binding.item = list[position]
        return binding.root
    }
    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(position: Int): Any {
        return list[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }
    fun addItem(string : String){
        list.add(string)
    }
    fun setList(datalist : ArrayList<String>){
        list = datalist
    }
}