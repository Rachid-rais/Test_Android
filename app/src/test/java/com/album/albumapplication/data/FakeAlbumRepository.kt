package com.album.albumapplication.data

import com.album.albumapplication.data.local.model.AlbumLocal
import com.album.albumapplication.data.mappers.NetworkAlbumToDatabaseAlbumMapper
import com.album.albumapplication.data.remote.model.AlbumNetwork
import com.album.albumapplication.data.remote.model.Result
import com.album.albumapplication.domain.BaseRepository
import kotlinx.coroutines.flow.Flow

class FakeAlbumRepository  : BaseRepository {

    private val dbAlbums = mutableListOf<AlbumLocal>()
    private var shouldReturnNetworkError = false
    private val albumMapper = NetworkAlbumToDatabaseAlbumMapper()

    private val remoteAlbums = listOf(
        AlbumNetwork(
            albumId = 0,
            id = 0,
            title = "Album 0",
            url = "https://www.google.fr/",
            thumbnailUrl = "https://www.google.fr/"
        ),
        AlbumNetwork(
            albumId = 1,
            id = 1,
            title = "Album 1",
            url = "https://www.google.fr/",
            thumbnailUrl = "https://www.google.fr/"
        ),
        AlbumNetwork(
            albumId = 2,
            id = 2,
            title = "Album 2",
            url = "https://www.google.fr/",
            thumbnailUrl = "https://www.google.fr/"
        )
    )



    fun setShouldReturnNetworkError(value: Boolean) {
        shouldReturnNetworkError = value
    }
    override suspend fun getAlbumListNetwork(): Result<List<AlbumNetwork>> {
        return if (shouldReturnNetworkError) {
            Result.error("Error", null)
        } else {
            for (d in remoteAlbums) {
                insertAlbum(albumMapper.map(d))
            }
            Result.success(remoteAlbums)
        }
    }

    override suspend fun insertAlbum(albumItem: AlbumLocal) {
        dbAlbums.add(albumItem)
    }

    override suspend fun getAlbumsLocal(): Flow<List<AlbumLocal>> {
        TODO("Not yet implemented")
    }
}