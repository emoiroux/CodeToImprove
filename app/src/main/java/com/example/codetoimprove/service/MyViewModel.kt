package com.example.codetoimprove.service

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.codetoimprove.data.myRepository
import kotlinx.coroutines.launch

lateinit var repository : myRepository

class MyViewModel(mRepository: myRepository) : ViewModel() {

    init {
        repository = mRepository
    }

    var data: MutableLiveData<String> = MutableLiveData("")

    fun FetchData(){
        repository.getData()!!
    }

    fun refreshData() {
        viewModelScope.launch {
           // refreshData()
        }
    }
}