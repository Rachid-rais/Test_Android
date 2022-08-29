package com.album.albumapplication.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.album.albumapplication.data.local.dao.AlbumDao
import com.album.albumapplication.data.local.model.AlbumLocal

/**
 * SQLite Database for storing the logs.
 */
@Database(entities = [AlbumLocal::class], version = 1, exportSchema = false)
abstract class AlbumDatabase :RoomDatabase(){
    abstract fun albumDao(): AlbumDao
}