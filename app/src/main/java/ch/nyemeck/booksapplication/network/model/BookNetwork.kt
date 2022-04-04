package ch.nyemeck.booksapplication.network.model

import com.google.gson.annotations.SerializedName

data class BookNetwork(
    @SerializedName("id")
    var id: String,

    @SerializedName("volumeInfo")
    var volumeInfo: VolumeInfo
)

data class VolumeInfo(
    @SerializedName("title")
    var title : String,

    @SerializedName("subtitle")
    var subtitle : String?,

    @SerializedName("imageLinks")
    var imageLinks : ImageLinks?
)

data class ImageLinks(
    @SerializedName("smallThumbnail")
    var smallThumbnail : String,

    @SerializedName("thumbnail")
    var thumbnail : String
)