package com.album.albumapplication.data

import com.album.albumapplication.data.local.AlbumLocalDataSource
import com.album.albumapplication.data.local.model.AlbumLocal
import com.album.albumapplication.data.remote.AlbumRemoteDatasource
import com.album.albumapplication.data.remote.model.AlbumNetwork
import com.album.albumapplication.data.remote.model.Result
import com.album.albumapplication.domain.BaseRepository
import dagger.hilt.android.scopes.ActivityRetainedScoped
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@ActivityRetainedScoped
class AlbumRepository @Inject constructor(
    private val localDatasource: AlbumLocalDataSource,
    private val remoteDatasource: AlbumRemoteDatasource
) : BaseRepository {
    override suspend fun getAlbumListNetwork(): Result<List<AlbumNetwork>> {
        return remoteDatasource.getAlbumList()
    }

    override suspend fun insertAlbum(albumItem: AlbumLocal) {
        localDatasource.insertAlbum(albumItem)
    }

    override suspend fun getAlbumsLocal(): Flow<List<AlbumLocal>> {
        return localDatasource.getAlbums()
    }
}