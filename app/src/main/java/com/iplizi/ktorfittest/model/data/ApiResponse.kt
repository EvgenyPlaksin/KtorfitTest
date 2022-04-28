package com.iplizi.ktorfittest.model.data

@kotlinx.serialization.Serializable
data class ApiResponse(
    val message: String? = null,
    val status: String? = null
)