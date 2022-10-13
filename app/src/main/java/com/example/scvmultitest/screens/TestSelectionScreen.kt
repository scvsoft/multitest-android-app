package com.example.scvmultitest.screens


import android.media.browse.MediaBrowser
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.scvmultitest.getMedia
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import coil.compose.ImagePainter.State.Empty.painter
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.example.scvmultitest.MediaItem

@ExperimentalFoundationApi
@Preview
@Composable
fun TestSelection() {
    LazyVerticalGrid(
        cells = GridCells.Adaptive(150.dp),
        contentPadding =  PaddingValues(20.dp)
    ){
        items(getMedia()){ item ->
            MediaListItem(item, Modifier.padding(10.dp))
        }
    }
}



@Composable
fun MediaListItem(item: MediaItem, modifier: Modifier = Modifier){

    Column(
        modifier = modifier
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .height(200.dp)
                .border(2.dp, Color.Gray, RoundedCornerShape(percent = 10))

        ){
            Image(painter = rememberImagePainter(
                data = item.thumb,
                builder = {
                    transformations(CircleCropTransformation())
                    crossfade(true)
                }
            ),
                contentDescription = null
            )

            Text(
                text = item.title,
                style = MaterialTheme.typography.h6
            )
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Preview(showBackground = true)
@Composable
fun TestSelectionPreview(){
    TestSelection()
}