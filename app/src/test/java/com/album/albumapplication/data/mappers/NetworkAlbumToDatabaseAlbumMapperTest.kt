package com.album.albumapplication.data.mappers

import com.album.albumapplication.data.local.model.AlbumLocal
import com.album.albumapplication.data.remote.model.AlbumNetwork
import org.junit.Assert
import org.junit.Test

class NetworkAlbumToDatabaseAlbumMapperTest {
    private val networkAlbum = AlbumNetwork(
        albumId = 0,
        id = 0,
        title = "Album 0",
        url = "https://www.google.com",
        thumbnailUrl = "https://www.google.com"
    )
    @Test
    fun map() {

        val actual = NetworkAlbumToDatabaseAlbumMapper().map(networkAlbum)

        val expected = AlbumLocal(
            id = 0,
            albumId = 0,
            title = "Album 0",
            url = "https://www.google.com",
            thumbnailUrl = "https://www.google.com"
        )

        Assert.assertEquals(expected, actual)
    }
}