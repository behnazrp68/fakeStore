package com.rajabi.fakestoreapplication.data.api

import com.rajabi.fakestoreapplication.data.model.APIResponse
import retrofit2.Response
import retrofit2.http.GET


interface StoreAPIServices {

    @GET("/products")
    suspend fun getAllProducts(): Response<APIResponse>

}