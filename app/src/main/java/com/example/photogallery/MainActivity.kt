package com.example.photogallery

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    companion object {
        val imageList = arrayListOf(
            ImageModel(0, R.drawable.image1, "Opis 1", 1f),
            ImageModel(1, R.drawable.image2, "Opis 2", 3f),
            // dodaj więcej obrazów
        )
    }

    private var imageList = mutableListOf<ImageModel>()
    private lateinit var adapter: ImageAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container, GalleryFragment())
                .commit()
        }

        supportFragmentManager.addOnBackStackChangedListener {
            if (supportFragmentManager.backStackEntryCount == 0) {
                // Refresh GalleryFragment
                supportFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container, GalleryFragment())
                    .commit()
            }
        }
    }

    fun openImageDetail(image: ImageModel) {
        val imageDetailFragment = ImageDetailFragment().apply {
            arguments = Bundle().apply {
                putParcelable("image", image)
            }
        }

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, imageDetailFragment)
            .addToBackStack(null)
            .commit()
    }

}
