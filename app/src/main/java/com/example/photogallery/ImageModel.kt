package com.example.photogallery

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ImageModel(
    val id: Int,
    val image: Int,
    val description: String,
    var rating: Float
): Parcelable



