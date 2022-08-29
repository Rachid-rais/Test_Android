package com.album.albumapplication.presentation.home

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.album.albumapplication.R
import com.album.albumapplication.databinding.ActivityHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private val viewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        binding.apply {
            setContentView(root)
        }
    }
    companion object {
        const val TAG = "HomeActivity"
        fun open(ctx: Context) {
            (ctx as AppCompatActivity).startActivity(Intent(ctx, HomeActivity::class.java))
            ctx.overridePendingTransition(
                R.anim.slide_in_up,
                R.anim.no_change
            )
        }
    }
}