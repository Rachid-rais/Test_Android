package com.album.albumapplication.domain

import com.album.albumapplication.data.local.model.AlbumLocal
import com.album.albumapplication.domain.model.Album

class AlbumsLocalMapper {
    fun map(input: List<AlbumLocal>): List<Album> {
        return input.map {
            mapAlbum(it)
        }
    }

    fun mapAlbum(input: AlbumLocal): Album {
        with(input) {
            return Album(id = id!!,title= title,image = thumbnailUrl)
        }
    }
}