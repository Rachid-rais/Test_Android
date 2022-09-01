package com.album.albumapplication.domain

import com.album.albumapplication.data.local.model.AlbumLocal
import com.album.albumapplication.domain.model.Album
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class AlbumLocalMapperTest {

    lateinit var albumLocal: AlbumLocal
    lateinit var mapper: AlbumLocalMapper

    @Before
    fun setUp() {
        albumLocal = AlbumLocal(
            id = 1,
            albumId = 1,
            title = "album1",
            url = "https://www.google.com/",
            thumbnailUrl = "https://www.google.com/"
        )

        mapper = AlbumLocalMapper()
    }

    @Test
    fun map() {
        val actual = mapper.map(albumLocal)

        val expected = Album(
            id = 1,
            title = "album1",
            image = "https://www.google.com/"
        )

        Assert.assertTrue(actual.image == expected.image)
    }


}