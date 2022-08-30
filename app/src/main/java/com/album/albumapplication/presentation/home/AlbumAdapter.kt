package com.album.albumapplication.presentation.home

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.album.albumapplication.R
import com.album.albumapplication.databinding.ItemAlbumBinding
import com.album.albumapplication.utils.ImageUtils
import com.album.albumapplication.domain.model.Album

class AlbumAdapter (val items: MutableList<Album>, val context:Context) :
    RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumViewHolder {
        val binding = ItemAlbumBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return AlbumViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size

    fun refresh(newItems: List<Album>) {
        items.clear()
        items.addAll(newItems)
        notifyDataSetChanged()
    }

    inner class AlbumViewHolder(private val binding: ItemAlbumBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(album: Album) {
            binding.tvAlbumTitle.text = album.title

            ImageUtils.loadImageFromUrl(
                context,
                album.image,
                binding.ivAlbum,
                R.mipmap.holder
            )

        }
    }
}