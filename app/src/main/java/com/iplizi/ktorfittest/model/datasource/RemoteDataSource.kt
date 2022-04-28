package com.iplizi.ktorfittest.model.datasource

import com.iplizi.ktorfittest.model.api.ApiService
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val apiService: ApiService) {

    suspend fun getData() = apiService.getData()

}