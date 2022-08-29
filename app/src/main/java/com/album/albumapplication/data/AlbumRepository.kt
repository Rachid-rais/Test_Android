package com.album.albumapplication.data

import com.album.albumapplication.data.remote.AlbumRemoteDatasource
import com.album.albumapplication.data.remote.model.AlbumNetwork
import com.album.albumapplication.data.remote.model.Result
import com.album.albumapplication.domain.BaseRepository
import dagger.hilt.android.scopes.ActivityRetainedScoped
import javax.inject.Inject

@ActivityRetainedScoped
class AlbumRepository @Inject constructor(
    private val remoteDatasource: AlbumRemoteDatasource
):BaseRepository {
    override suspend fun getAlbumListNetwork(): Result<List<AlbumNetwork>> {
        return remoteDatasource.getAlbumList()
    }
}