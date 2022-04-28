package com.iplizi.ktorfittest.model.di

import com.iplizi.ktorfittest.model.api.ApiService
import com.iplizi.ktorfittest.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import de.jensklingenberg.ktorfit.Ktorfit
import de.jensklingenberg.ktorfit.adapter.FlowResponseConverter
import de.jensklingenberg.ktorfit.create
import io.ktor.client.*


import kotlinx.serialization.json.Json
import javax.inject.Singleton
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
