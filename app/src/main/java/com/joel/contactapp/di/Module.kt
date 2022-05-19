package com.joel.contactapp.di

import android.app.Application
import androidx.room.Room
import com.joel.contactapp.data.ContactDatabase
import com.joel.contactapp.data.Repository
import com.joel.contactapp.data.RepositoryImplemen
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object Module {
    @Provides
    @Singleton
    fun provideDataBase(app : Application ) : ContactDatabase{
        return Room.databaseBuilder(
            app,
            ContactDatabase::class.java,
            "Contact Database"
        ).build()
    }
    @Provides
    @Singleton
    fun provideRepository(database: ContactDatabase) : Repository {
       return RepositoryImplemen(database.dao)
    }
}