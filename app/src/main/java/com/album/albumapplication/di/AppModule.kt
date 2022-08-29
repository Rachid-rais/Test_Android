package com.album.albumapplication.di

import android.content.Context
import android.content.SharedPreferences
import com.album.albumapplication.data.AlbumRepository
import com.album.albumapplication.data.remote.AlbumHomeRemote
import com.album.albumapplication.data.remote.AlbumRemoteDatasource
import com.album.albumapplication.domain.BaseRepository
import com.album.albumapplication.utils.Constants
import com.album.albumapplication.utils.PreferenceHelper
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {
    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient
            .Builder()
            .readTimeout(15, TimeUnit.SECONDS)
            .connectTimeout(15, TimeUnit.SECONDS)
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient, gson: Gson): Retrofit = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    @Provides
    fun provideGson(): Gson = GsonBuilder().create()

    @Provides
    fun provideSmartPreferences(@ApplicationContext appContext: Context): SharedPreferences = PreferenceHelper.albumPrefs(appContext)

    @Provides
    fun provideAlbumListService(retrofit: Retrofit): AlbumHomeRemote = retrofit.create(AlbumHomeRemote::class.java)

    @Singleton
    @Provides
    fun provideAlbumRepository(
        remoteDatasource: AlbumRemoteDatasource
    ) = AlbumRepository(remoteDatasource) as BaseRepository

}