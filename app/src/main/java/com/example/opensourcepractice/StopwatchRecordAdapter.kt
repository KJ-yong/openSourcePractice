package com.example.opensourcepractice

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.opensourcepractice.databinding.StopwatchRecyclerBinding

class StopwatchRecordAdapter(private val context : Context) : RecyclerView.Adapter<StopwatchRecordAdapter.ViewHolder>() {
    private var datas = mutableListOf<String>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = StopwatchRecyclerBinding.inflate(LayoutInflater.from(context),parent,false)
        return ViewHolder(binding)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(datas[position])
    }
    override fun getItemCount(): Int = datas.size
    fun setData(dataList : ArrayList<String>){
        datas = dataList
        notifyDataSetChanged()
    }
    inner class ViewHolder(private val binding : StopwatchRecyclerBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(item : String){
            binding.item = item
        }
    }
}