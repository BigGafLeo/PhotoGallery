package com.example.photogallery

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView

class ImageDetailFragment : Fragment() {
    private lateinit var image: ImageModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_image_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        image = arguments?.getParcelable("image") ?: return

        val imageView = view.findViewById<ImageView>(R.id.image_view)
        val descriptionView = view.findViewById<TextView>(R.id.image_description)
        val ratingBar = view.findViewById<RatingBar>(R.id.rating_bar)

        imageView.setImageResource(image.image)
        descriptionView.text = image.description
        ratingBar.rating = image.rating

        ratingBar.setOnRatingBarChangeListener { _, rating, _ ->
            image.rating = rating
            MainActivity.imageList[image.id] = image
        }

        view.findViewById<Button>(R.id.button_back).setOnClickListener {
            parentFragmentManager.popBackStack()
        }
    }
    override fun onPause() {
        super.onPause()
        val ratingBar = view?.findViewById<RatingBar>(R.id.rating_bar)
        image.rating = ratingBar?.rating ?: image.rating
    }
}