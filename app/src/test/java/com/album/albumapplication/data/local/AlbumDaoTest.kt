package com.album.albumapplication.data.local

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.album.albumapplication.data.local.dao.AlbumDao
import com.album.albumapplication.data.local.model.AlbumLocal
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.TestCoroutineScope
import org.junit.*
import org.junit.runner.RunWith

@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
class AlbumDaoTest {

    private lateinit var database: AlbumDatabase
    private lateinit var albumDao: AlbumDao

    private val dispatcher = TestCoroutineDispatcher()
    private val testScope = TestCoroutineScope(dispatcher)

    private val album0 = AlbumLocal(
        id = 0,
        albumId = 0,
        title = "Album0",
        url = "https://www.google.fr/",
        thumbnailUrl = "https://www.google.fr/"
    )

    @Before
    fun setup() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            AlbumDatabase::class.java
        ).allowMainThreadQueries().build()

        albumDao = database.albumDao()
    }

    @After
    fun teardown() {
        database.close()
    }

    @Test
    fun insertAlbum() {
        testScope.launch {
            albumDao.insertAlbum(album0)
            albumDao.getAlbums().collect { albums ->
                Assert.assertTrue(albums.size == 1)
                Assert.assertTrue(albums.contains(album0))
            }
        }
    }

}