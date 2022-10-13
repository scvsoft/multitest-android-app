package com.example.scvmultitest

data class MediaItem (
    val id: Int,
    val title: String,
    val thumb: Int,
){
}

fun getMedia() = (1..5).map{
    MediaItem(
        id = it,
        title = " Title $it",
        thumb= R.drawable.scvsoft
    )
}