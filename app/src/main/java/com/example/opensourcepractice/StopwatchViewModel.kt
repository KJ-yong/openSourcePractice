package com.example.opensourcepractice

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.*
import kotlin.collections.ArrayList
import kotlin.concurrent.timer

class StopwatchViewModel : ViewModel() {
    private val _time = MutableLiveData<String>()
    private val _recordList = MutableLiveData<ArrayList<String>>()
    val time : LiveData<String>
    get() = _time
    val recordList : LiveData<ArrayList<String>>
    get() = _recordList
    private var items = ArrayList<String>()
    private var timer : Timer? = null
    private var min = 0
    private var sec = 0
    private var miliSec = 0
    init{
        _time.value = "00:00:00"
        _recordList.value = items
    }
    private fun itemAdd(data : String){
        items.add(data)
        _recordList.postValue(items)
    }
    fun startTimer(){
        timer = timer(period = 10){
            miliSec++
            if(miliSec>=100){
                sec++
                miliSec = 0
                if(sec>=60){
                    min++
                    sec = 0
                }
            }
            _time.postValue(intToString(min)+":"+intToString(sec)+":"+intToString(miliSec))
            if(sec%10==0&&miliSec==0){
                itemAdd("10초 경과("+_time.value+")")
            }
        }
    }
    fun stopTimer(){
        timer?.cancel()
    }
    fun clear(){
        min = 0
        sec = 0
        miliSec = 0
        _time.value = "00:00:00"
        items.clear()
        _recordList.value = items
    }
    private fun intToString(num:Int):String{
        return if(num>=10) num.toString()
        else "0$num"
    }
}