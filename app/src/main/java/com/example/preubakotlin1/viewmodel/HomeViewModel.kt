package com.example.preubakotlin1.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.preubakotlin1.model.Dog
import com.example.preubakotlin1.model.DogApi
import com.example.preubakotlin1.model.DogService
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel : ViewModel() {
    private var _dog = MutableLiveData<Dog>()
    val dog:LiveData<Dog>
    get() = _dog

    private var _loading = MutableLiveData<Boolean>()
    val loading:LiveData<Boolean>
        get() = _loading

    private var _error = MutableLiveData<String>()
    val error:LiveData<String>
        get() = _error


    private val dogApiService = DogService.getDogApi()


    fun getRandomDog(){
        _loading.value = true
        viewModelScope.launch {
            val response = dogApiService.getDog()

            if (response.isSuccessful){

                _dog.value = response.body()
                _loading.value = false
            }else{
                _error.value = response.message()
                _loading.value = false
            }

        }
    }
}