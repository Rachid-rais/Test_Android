package com.album.albumapplication.data.local.dao

import androidx.room.*
import com.album.albumapplication.data.local.model.AlbumLocal
import kotlinx.coroutines.flow.Flow

@Dao
interface AlbumDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAlbum(albumItem: AlbumLocal)

    @Query("SELECT * FROM album")
    fun getAlbums(): Flow<List<AlbumLocal>>

}