package com.example.opensourcepractice

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CalculViewModel : ViewModel() {
    private val _answer = MutableLiveData<String>()
    val answer : LiveData<String>
    get()=_answer
    private val _expression = MutableLiveData<String>()
    val expression : LiveData<String>
    get() = _expression
    private var init : Boolean = true
    private var nomial1 : String = ""
    private var nomial2 : String = ""
    private var operator : String = ""
    init {
        _answer.value = "0"
        _expression.value = ""
    }
    fun inputNumber(num : String){
        if(init||_answer.value=="0"){
            _answer.value = num
            init = false
        }
        else _answer.value += num
    }
    fun inputClear(){
        init = true
        _answer.value = "0"
        _expression.value = ""
        nomial1 = ""
        nomial2 = ""
        operator = ""
    }
    private fun calculate(operater : String) : String{
        return if(operater=="+"){
            (nomial1.toInt() + nomial2.toInt()).toString()
        } else if(operater=="-"){
            (nomial1.toInt() - nomial2.toInt()).toString()
        } else if(operater=="*"){
            (nomial1.toInt() * nomial2.toInt()).toString()
        } else (nomial1.toInt() / nomial2.toInt()).toString()
    }
    fun inputOperator(input : String){
        nomial2 = ""
        if(!init){
            if(nomial1.isEmpty()){
                nomial1 = _answer.value!!
                _answer.value = ""
            } else{
                nomial2 = _answer.value!!
                nomial1 = calculate(operator)
                _answer.value = nomial1
                nomial2 = ""
            }
            init = true
        }
        operator = input
        _expression.value = nomial1+operator
    }
    fun inputEqual(){
        if(init){
            if(nomial2.isEmpty()) nomial2 = nomial1
            _expression.value = "$nomial1 $operator $nomial2 ="
            nomial1 =calculate(operator)
            _answer.value = nomial1
        } else{
            if(nomial1.isNotEmpty()){
                nomial2 = _answer.value!!
                _expression.value = "$nomial1 $operator $nomial2 ="
                nomial1 = calculate(operator)
                _answer.value = nomial1
            }
        }
        init = true
    }
}