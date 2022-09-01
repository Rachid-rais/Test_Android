package com.album.albumapplication.data.mappers

interface Mapper<I, T> {
    fun map(input: I): T
}