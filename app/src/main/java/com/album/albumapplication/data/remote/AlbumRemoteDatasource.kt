package com.album.albumapplication.data.remote

import javax.inject.Inject

class AlbumRemoteDatasource @Inject constructor(
    private val AlbumListService: AlbumHomeRemote
) : BaseDataSource() {
    suspend fun getAlbumList() = getResult { AlbumListService.getAlbumList() }
}