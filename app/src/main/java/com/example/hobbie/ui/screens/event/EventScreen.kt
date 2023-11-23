package com.example.hobbie.ui.screens.event

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.hobbie.ui.screens.event.components.BottomSheet
import com.example.hobbie.ui.shared.ImageAndBlur

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EventScreen(
    navController: NavHostController
) {
    val eventViewModel: EventViewModel = hiltViewModel()

    val event = eventViewModel.event.collectAsState().value

    val scaffoldState = rememberBottomSheetScaffoldState()

    if (event !== null) {
        Scaffold(
            bottomBar = {
                Button(
                    modifier = Modifier
                        .padding(horizontal = 16.dp, vertical = 16.dp)
                        .fillMaxWidth(),
                    onClick = { /*TODO*/ },
                    shape = RoundedCornerShape(percent = 100),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF292524)
                    )
                ) {
                    Text(
                        text = "Confirmar Presença",
                        style = TextStyle(
                            fontSize = 18.sp,
                            lineHeight = 28.sp,
                            fontWeight = FontWeight(500),
                            color = Color(0xFFF5F5F4),
                        )
                    )
                }
            }
        ) {
            BoxWithConstraints(
              modifier = Modifier
            ) {
                BottomSheetScaffold(
                    scaffoldState = scaffoldState,
                    sheetContent = {
                        BottomSheet(
                            event = event
                        )
                    },
                    sheetContainerColor = Color.White,
                    sheetPeekHeight = this.maxHeight * 0.43f,
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(color = Color(0x77555555))
                    ) {
                        FilledIconButton(
                            onClick = {
                                navController.popBackStack()
                            },
                            modifier = Modifier
                                .padding(top = 24.dp, start = 24.dp)
                                .zIndex(99f),
                            colors = IconButtonDefaults.filledIconButtonColors(
                                containerColor = Color(0xFFFFA500),
                                contentColor = Color(0xFF000000)
                            )
                        ) {
                            Icon(
                                Icons.Filled.KeyboardArrowLeft,
                                contentDescription = "",
                                modifier = Modifier
                                    .size(36.dp),
                            )
                        }

                        Box(
                            modifier = Modifier
                                .fillMaxHeight(0.6f)
                        ) {
                            ImageAndBlur(
                                thumbnail = event.thumbnail
                            )
                        }
                    }
                }
            }
        }
    }
}
