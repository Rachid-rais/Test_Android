package com.album.albumapplication.domain

import com.album.albumapplication.data.local.model.AlbumLocal
import com.album.albumapplication.data.remote.model.AlbumNetwork
import com.album.albumapplication.data.remote.model.Result
import kotlinx.coroutines.flow.Flow

interface BaseRepository {
    suspend fun getAlbumListNetwork(): Result<List<AlbumNetwork>>

    suspend fun insertAlbum(albumItem: AlbumLocal)

    suspend fun getAlbumsLocal(): Flow<List<AlbumLocal>>
}