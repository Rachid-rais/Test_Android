package com.album.albumapplication.domain

import com.album.albumapplication.data.remote.model.AlbumNetwork
import com.album.albumapplication.data.remote.model.Result

interface BaseRepository {
    suspend fun getAlbumListNetwork(): Result<List<AlbumNetwork>>

}