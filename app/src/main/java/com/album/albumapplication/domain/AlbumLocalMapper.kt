package com.album.albumapplication.domain

import androidx.annotation.VisibleForTesting
import com.album.albumapplication.data.local.model.AlbumLocal
import com.album.albumapplication.data.mappers.Mapper
import com.album.albumapplication.domain.model.Album

class AlbumLocalMapper : Mapper<AlbumLocal, Album> {
    @VisibleForTesting
    override fun map(input: AlbumLocal): Album {
        with(input){
            return Album(id = id!!, title = title, image = url)
        }
    }
}