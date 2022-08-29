package com.album.albumapplication.data.remote

import android.util.Log
import com.album.albumapplication.data.remote.model.Result
import retrofit2.Response

abstract class BaseDataSource {

    /**
     * Generic Function for emitting with mapped datas.
     */
    protected suspend fun <T> getResult(call: suspend () -> Response<T>): Result<T> {
        try {
            val response = call()
            if (response.isSuccessful) {
                val body = response.body()
                if (body != null) return Result.success(body)
            }
            return error(" ${response.code()} ${response.message()}")
        } catch (e: Exception) {
            return error(e.message ?: e.toString())
        }
    }

    private fun <T> error(message: String): Result<T> {
        Log.d(TAG, message)
        return Result.error("Network call failed: $message")
    }

    companion object {
        const val TAG = "BaseDataSource"
    }
}