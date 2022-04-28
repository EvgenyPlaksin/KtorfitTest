package com.iplizi.ktorfittest.model.di

import com.iplizi.ktorfittest.utils.Constants
import de.jensklingenberg.ktorfit.Ktorfit
import de.jensklingenberg.ktorfit.adapter.FlowResponseConverter
import io.ktor.client.*


import kotlinx.serialization.json.Json

import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*


object AppModule {

    val ktorfit = Ktorfit(Constants.BASE_URL, HttpClient {
        install(ContentNegotiation) {
            json(Json { isLenient = true; ignoreUnknownKeys = true })
        }
    }).also {
        it.addResponseConverter(FlowResponseConverter())
    }

}
