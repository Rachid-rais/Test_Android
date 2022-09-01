package com.album.albumapplication.domain

import com.album.albumapplication.data.local.model.AlbumLocal
import com.album.albumapplication.data.mappers.ListMapper
import com.album.albumapplication.data.mappers.Mapper
import com.album.albumapplication.domain.model.Album

class AlbumsLocalMapper(private val mapper: Mapper<AlbumLocal, Album>) : ListMapper<AlbumLocal, Album> {
    override fun map(input: List<AlbumLocal>): List<Album> {
            return input.map {
                mapper.map(it)
            }
    }

}