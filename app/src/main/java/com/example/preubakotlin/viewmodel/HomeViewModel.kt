package com.example.preubakotlin.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.preubakotlin.model.Platform
import com.example.preubakotlin.model.PlatformService
import kotlinx.coroutines.launch
import okhttp3.RequestBody

class HomeViewModel : ViewModel() {
    private var _platformsList = MutableLiveData<List<Platform>>()
    val platformsList:LiveData<List<Platform>>
    get() = _platformsList

    private var _loading = MutableLiveData<Boolean>()
    val loading:LiveData<Boolean>
        get() = _loading

    private var _error = MutableLiveData<String>()
    val error:LiveData<String>
        get() = _error


    private val dogApiService = PlatformService.getDogApi()


    fun getRandomDog(apiKey: String){
        _loading.value = true
        viewModelScope.launch {
            val response = dogApiService.getPlatforms(apiKey)

            if (response.isSuccessful){
                _platformsList.value = response.body()
                _loading.value = false
            }else{
                _error.value = response.message()
                _loading.value = false
            }

        }
    }
}