package com.album.albumapplication.data

import com.album.albumapplication.domain.BaseRepository
import dagger.hilt.android.scopes.ActivityRetainedScoped
import javax.inject.Inject

@ActivityRetainedScoped
class AlbumRepository @Inject constructor():BaseRepository {
}