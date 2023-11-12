package com.example.hobbie.ui.screens.home

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.Menu
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.hobbie.R
import com.example.hobbie.ui.screens.home.components.BottomSheet

@Composable
fun HomeScreen() {
    val homeViewModel: HomeViewModel = viewModel()

    val isBottomSheetOpen = homeViewModel.isBottomSheetOpen.value

    Column(
        modifier = Modifier
            .padding(top = 24.dp, start = 24.dp, end = 24.dp, bottom = 108.dp),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Vitória")

            Column(
                modifier = Modifier,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Pra voce",
                    style = TextStyle(
                        fontSize = 24.sp,
                        lineHeight = 32.sp,
                        fontWeight = FontWeight(500),
                        color = Color.Black,
                    )
                )

                Text(
                    text = "Vitória",
                    style = TextStyle(
                        fontSize = 12.sp,
                        lineHeight = 16.sp,
                        fontWeight = FontWeight(500),
                        color = Color.Black,
                    )
                )
            }

//            Text(
//                text = isBottomSheetOpen.toString(),
//                modifier = Modifier,
//                color = Color(0xFFFF7930)
//            )

            FilledIconButton(
                onClick = {
                    homeViewModel.onChangeBottomSheetState()
                },
                modifier = Modifier,
                shape = RoundedCornerShape(size = 8.dp),
                colors = IconButtonDefaults.filledIconButtonColors(
                    containerColor = Color.White,
                )
            ) {
                Icon(
                    Icons.Sharp.Menu,
                    contentDescription = "Filtro",
                    tint = Color(0xFFFF7930)
                )
            }
        }


        Box(
            modifier = Modifier
                .background(Color(0x33FF0000))
                .fillMaxSize(),
        ) {
            AsyncImage(
                model = "https://variety.com/wp-content/uploads/2021/07/Rick-Astley-Never-Gonna-Give-You-Up.png?w=1024",
//                model = ImageRequest.Builder(LocalContext.current)
//                    .data("https://variety.com/wp-content/uploads/2021/07/Rick-Astley-Never-Gonna-Give-You-Up.png?w=1024")
//                    .crossfade(true)
//                    .build(),
                contentDescription = null,
                modifier = Modifier,
                placeholder = painterResource(R.drawable.hobbie_logo),
            )
        }


    }
    BottomSheet()
}






@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}
