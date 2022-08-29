package com.album.albumapplication.domain.model

import java.io.Serializable

open class Album(
    open val id: Int,
    open val title: String,
    val image: String
) : Serializable
