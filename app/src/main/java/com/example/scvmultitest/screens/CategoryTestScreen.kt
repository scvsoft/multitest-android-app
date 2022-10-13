package com.example.scvmultitest.screens


import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.scvmultitest.getMedia
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.example.scvmultitest.MediaItem

@ExperimentalFoundationApi
@Preview
@Composable
fun CategoryTest() {
    LazyVerticalGrid(
        cells = GridCells.Adaptive(160.dp),
        contentPadding =  PaddingValues(15.dp)
    ){
        items(getMedia()){ item ->
            MediaListItem(item, Modifier.padding(5.dp))
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
                .height(180.dp)
                .border(2.dp, Color.Gray, RoundedCornerShape(percent = 10))

        ){
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
                ) {
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
}

@OptIn(ExperimentalFoundationApi::class)
@Preview(showBackground = true)
@Composable
fun CategoryTestPreview(){
    CategoryTest()
}