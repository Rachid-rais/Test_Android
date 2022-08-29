package com.album.albumapplication.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "album")
data class AlbumLocal(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val albumId: Int,
    val title: String,
    val url: String,
    val thumbnailUrl: String
) : Serializable