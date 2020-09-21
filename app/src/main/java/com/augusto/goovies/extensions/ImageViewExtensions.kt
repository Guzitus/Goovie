package com.augusto.goovies.extensions

import android.net.Uri
import android.widget.ImageView
import coil.load
import coil.size.Scale
import coil.transform.RoundedCornersTransformation

class CoilLoadBuilder(
    var uri: String? = null,
    var corners: Boolean = false,
    var cornersRadius: Float = 6f,
    var onSuccess: () -> Unit = {}
)

fun ImageView.loadImageCoil(
    scope: CoilLoadBuilder.() -> Unit
) {
    val builder = CoilLoadBuilder().apply(scope)
    with(builder) {
        load(uri) {
            scale(Scale.FIT)
            if (corners)
                transformations(RoundedCornersTransformation(cornersRadius))
            listener { _, _ ->
                onSuccess.invoke()
            }
        }
    }
}