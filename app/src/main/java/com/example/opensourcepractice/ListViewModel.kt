package com.example.opensourcepractice

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ListViewModel : ViewModel(){
    private val _list = MutableLiveData<ArrayList<String>>()
    val list : LiveData<ArrayList<String>>
    get() = _list
    private var items = ArrayList<String>()
    init{
        _list.value = items
    }
    fun addItem(string: String){
        items.add(string)
        _list.value = items
    }
}