package com.iplizi.ktorfittest.model.repository


import com.iplizi.ktorfittest.model.api.ApiService
import com.iplizi.ktorfittest.model.data.ApiResponse
import com.iplizi.ktorfittest.model.di.AppModule
import de.jensklingenberg.ktorfit.create


class Repository {
   suspend fun getData(): ApiResponse {
        val api = AppModule.ktorfit.create<ApiService>()
           return api.getData()
    }
}