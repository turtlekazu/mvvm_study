package com.example.mvvm_study.model.remote_data_source.apiclient

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ApiClientModule {
    @Provides
    @Singleton
    fun provideApiClient(apiClientProvider: ApiClientProvider): ApiClient {
        return apiClientProvider.provide()
    }
}