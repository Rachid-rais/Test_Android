package com.album.albumapplication.data.remote

import com.album.albumapplication.data.remote.model.AlbumNetwork
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface AlbumHomeRemote {

    @GET("/img/shared/technical-test.json")
    @Headers("Accept: application/json", "Content-Type: application/json")
    suspend fun getAlbumList(): Response<List<AlbumNetwork>>
}