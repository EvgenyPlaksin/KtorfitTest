package com.iplizi.ktorfittest.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iplizi.ktorfittest.model.data.ApiResponse
import com.iplizi.ktorfittest.model.repository.Repository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {

    private var _data: MutableStateFlow<ApiResponse?> = MutableStateFlow(null)
    val data: StateFlow<ApiResponse?> = _data

    private val repository = Repository()

    fun init(){
        fetchApiResponse()
    }

  private fun fetchApiResponse() = viewModelScope.launch {
           _data.value = repository.getData()
        }
}