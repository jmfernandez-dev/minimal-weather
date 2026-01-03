package com.jmfernandez.weather.di

import android.app.Application
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.jmfernandez.weather.data.location.DefaultLocationTracker
import com.jmfernandez.weather.domain.location.LocationTracker
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocationModule {

    @Provides
    @Singleton
    fun provideFusedLocationProviderClient(app: Application): FusedLocationProviderClient {
        return LocationServices.getFusedLocationProviderClient(app)
    }

    @Provides
    @Singleton
    fun provideLocationTracker(fusedLocationProviderClient: FusedLocationProviderClient, app: Application): LocationTracker {
        return DefaultLocationTracker(
            fusedLocationProviderClient = fusedLocationProviderClient,
            application = app
        )
    }
}