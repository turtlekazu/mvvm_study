package com.example.mvvm_study.model.remote_data_source.apiclient

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import javax.inject.Inject

class ApiClientProvider @Inject constructor() {
    companion object {
        private const val API_END_POINT = "https://api.github.com"
    }

    private val jsonFormat = Json {
        ignoreUnknownKeys = true
    }

    fun provide(): ApiClient {
        return Retrofit.Builder()
            .baseUrl(API_END_POINT)
            .addConverterFactory(
                jsonFormat.asConverterFactory(
                    "application/json".toMediaType()
                ),
            )
            .build()
            .create(ApiClient::class.java)
    }
}