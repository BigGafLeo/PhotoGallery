package com.example.photogallery

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class GalleryFragment : Fragment() {
    private var imageList = mutableListOf<ImageModel>()
    private lateinit var adapter: ImageAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_gallery, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view)
        val imageListAdapter = ImageAdapter(MainActivity.imageList) { image ->
            (activity as? MainActivity)?.openImageDetail(image)
        }

        recyclerView.adapter = imageListAdapter
        recyclerView.layoutManager = LinearLayoutManager(context)
    }

    private fun imageClicked(image: ImageModel) {
        (activity as? MainActivity)?.openImageDetail(image)
    }
}