package com.album.albumapplication.presentation.splashscreen


import android.content.SharedPreferences
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.album.albumapplication.data.FakeAlbumRepository
import com.album.albumapplication.data.mappers.NetworkAlbumToDatabaseAlbumMapper
import com.album.albumapplication.utils.MainCoroutineRule
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.runBlockingTest
import org.junit.*
import org.mockito.Mockito

class SplashViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    private lateinit var viewModel: SplashViewModel

    lateinit var sharedPrefs: SharedPreferences
    lateinit var mockEditor: SharedPreferences.Editor
    @Before
    fun setUp() {
        sharedPrefs = Mockito.mock(SharedPreferences::class.java)
        mockEditor = Mockito.mock(SharedPreferences.Editor::class.java)

        Mockito.`when`(sharedPrefs.edit()).thenReturn(mockEditor)

        viewModel = SplashViewModel(
            repository = FakeAlbumRepository(),
            albumMapper = NetworkAlbumToDatabaseAlbumMapper(),
            albumPrefs = sharedPrefs
        )
    }
    @Test
    fun `load Albums file from remote and store inside database`() {

        mainCoroutineRule.runBlockingTest {

            launch {
                viewModel.loadAlbum()
            }

            val result = viewModel.state.value

            Assert.assertTrue(result is SplashScreenViewState.ContentLoaded)
        }
    }

    @After
    fun tearDown() {
        // do something if required
    }
}