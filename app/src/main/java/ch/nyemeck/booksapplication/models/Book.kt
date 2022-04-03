package ch.nyemeck.booksapplication.models

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide


data class Book(
    val title : String,
    val subtitle : String,
    val thumbnail : String?,
    //var authors : List<String>,
    //var thumbnail : String,
    //var previewLink : String
    ){
    companion object {
        @JvmStatic
        @BindingAdapter("loadImage")
        fun loadImage(view: ImageView, bookImage: String?) {
            bookImage?.let {
                Glide.with(view.context)
                    //.asBitmap()
                    .load(bookImage)
                    //.fallback(com.google.android.material.R.drawable.mtrl_ic_error)
                    //.error(com.google.android.material.R.drawable.mtrl_ic_error)
                    .into(view)
            }

        }
    }
}
