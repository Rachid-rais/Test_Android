package com.album.albumapplication.data.mappers

import com.album.albumapplication.data.local.model.AlbumLocal
import com.album.albumapplication.data.remote.model.AlbumNetwork
import javax.inject.Inject

class NetworkAlbumToDatabaseAlbumMapper @Inject constructor() {
    fun map(input: AlbumNetwork): AlbumLocal {
        with(input) {
            return AlbumLocal(
                id = id,
                albumId = albumId,
                title = title,
                url = url,
                thumbnailUrl = thumbnailUrl
            )
        }
    }
}