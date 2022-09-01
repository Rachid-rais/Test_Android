package com.album.albumapplication.domain

import com.album.albumapplication.data.local.model.AlbumLocal
import com.album.albumapplication.domain.model.Album
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class AlbumsLocalMapperTest {

    lateinit var mapper: AlbumsLocalMapper
    private lateinit var albumsLocal: List<AlbumLocal>
    var album1 = Album(
        id = 1,
        title = "album1",
        image = "https://www.google.com"
    )
    var album2 = Album(
        id = 2,
        title = "album2",
        image = "https://www.google.com"
    )

    @Before
    fun setUp() {
        mapper = AlbumsLocalMapper(AlbumLocalMapper())
        albumsLocal = listOf(
            AlbumLocal(
                id = 1,
                albumId = 1,
                title = "album1",
                url = "https://www.google.com",
                thumbnailUrl = "https://www.google.com"
            ),
            AlbumLocal(
                id = 2,
                albumId = 2,
                title = "album2",
                url = "https://www.google.com",
                thumbnailUrl = "https://www.google.com"
            )
        )
    }

    @Test
    fun map() {

        val actual = mapper.map(albumsLocal)

        val expected = listOf(album1,album2)

        Assert.assertTrue(actual.size == expected.size)
        Assert.assertEquals(expected[0].title, actual[0].title)
    }


}