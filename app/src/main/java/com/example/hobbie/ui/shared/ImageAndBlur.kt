package com.example.hobbie.ui.shared

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layout
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.hobbie.models.EventItem

@Composable
fun ImageAndBlur(
    thumbnail: String?,
) {
//    Box(
//        modifier = Modifier
//            .fillMaxHeight(0.6f)
//    ) {
        // IMAGE FROM BACKGROUND TO BLUR EFFECT
        AsyncImage(
            model = thumbnail,
            contentDescription = null,
            modifier = Modifier
                .fillMaxHeight()
                .blur(16.dp),
            contentScale = ContentScale.Crop
        )



        // MAIN IMAGE
        AsyncImage(
            model = thumbnail,
            contentDescription = null,
            modifier = Modifier
                .layout { measurable, constraints ->
                    val placeable =
                        measurable.measure(
                            constraints.copy(minWidth = 0, minHeight = 0)
                        )
                    layout(constraints.maxWidth, constraints.maxHeight) {
                        val x = (constraints.maxWidth - placeable.width) / 2
                        val y = (constraints.maxHeight - placeable.height) / 2
                        placeable.placeRelative(x, y)
                    }
                },
        )
//    }
}