package com.album.albumapplication.presentation.home

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.album.albumapplication.R
import com.album.albumapplication.databinding.ActivityHomeBinding
import com.album.albumapplication.domain.AlbumsLocalMapper
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    private val viewModel: HomeViewModel by viewModels()

    private lateinit var albumAdapter: AlbumAdapter

    @Inject
    lateinit var mapperAlbums: AlbumsLocalMapper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        binding.apply {
            setContentView(root)
        }
        initBindings()
        setUpObservers()
        viewModel.onEvent(HomeViewState.EntryScreen)
    }

    private fun initBindings() {
        initRecyclerViews()
    }

    private fun setUpObservers() {
        viewModel.state.observe(this) {
            render(it)
        }
    }

    private fun render(homeViewState: HomeViewState) {
        when (homeViewState) {
            is HomeViewState.Content -> {
                albumAdapter.refresh(mapperAlbums.map(homeViewState.albums))
            }
            HomeViewState.EmptyContent -> {
                Log.d(TAG, "EmptyContent")
            }
            HomeViewState.Loading -> {
                Log.d(TAG, "Loading")
            }
            else -> {}
        }
    }

    override fun onPause() {
        super.onPause()
    }

    private fun initRecyclerViews() {
        albumAdapter = AlbumAdapter(ArrayList(),this)
        binding.rvAlbums.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = albumAdapter
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