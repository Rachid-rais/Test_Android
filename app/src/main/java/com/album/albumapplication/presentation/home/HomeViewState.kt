package com.album.albumapplication.presentation.home

import com.album.albumapplication.data.local.model.AlbumLocal

sealed class HomeViewState {

    object EntryScreen : HomeViewState()
    object Loading : HomeViewState()
    data class Content(val albums: List<AlbumLocal>) : HomeViewState()
    object EmptyContent : HomeViewState()

}