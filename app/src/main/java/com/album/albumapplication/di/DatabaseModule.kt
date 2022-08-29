package com.album.albumapplication.di

import android.content.Context
import androidx.room.Room
import com.album.albumapplication.data.local.AlbumDatabase
import com.album.albumapplication.data.local.dao.AlbumDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext appContext: Context): AlbumDatabase {
        return Room.databaseBuilder(
            appContext,
            AlbumDatabase::class.java,
            "albumlist.db"
        ).build()
    }

    @Singleton
    @Provides
    fun provideDevicesDao(database: AlbumDatabase): AlbumDao {
        return database.albumDao()
    }
}