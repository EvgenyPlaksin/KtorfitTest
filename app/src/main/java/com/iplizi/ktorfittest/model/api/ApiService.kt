package com.iplizi.ktorfittest.model.api

import com.iplizi.ktorfittest.model.data.ApiResponse
import com.iplizi.ktorfittest.utils.Constants
import de.jensklingenberg.ktorfit.http.GET
import kotlinx.coroutines.flow.Flow

interface ApiService {

    @GET(Constants.RANDOM_URL)
    suspend fun getData(): ApiResponse

}