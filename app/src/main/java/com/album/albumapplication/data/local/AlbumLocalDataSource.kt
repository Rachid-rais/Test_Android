package com.album.albumapplication.data.local

import com.album.albumapplication.data.local.dao.AlbumDao
import com.album.albumapplication.data.local.model.AlbumLocal
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AlbumLocalDataSource @Inject constructor(
    private val albumDao: AlbumDao
) {
    fun getAlbums(): Flow<List<AlbumLocal>> {
        return albumDao.getAlbums()
    }
    suspend fun insertAlbum(albumItem: AlbumLocal) {
        albumDao.insertAlbum(albumItem)
    }
}