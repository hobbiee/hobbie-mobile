package com.example.hobbie.ui.shared.BottomSheetFilter

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.hilt.navigation.compose.hiltViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheet(
    isBottomSheetOpen: Boolean,
    onChangeBottomSheetState: () -> Unit,
) {
    val bottomSheetViewModel: BottomSheetViewModel = hiltViewModel()

    val interessesList = bottomSheetViewModel.interessesList

    val interessesSelecionados = bottomSheetViewModel.interessesSelecionados

    val distance = bottomSheetViewModel.distance.value

    val sheetState = rememberModalBottomSheetState()

    if(isBottomSheetOpen) {
        ModalBottomSheet(
            onDismissRequest = {
                onChangeBottomSheetState()
            },
            sheetState = sheetState,
            containerColor = Color.White,
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 36.dp, end = 36.dp, top = 0.dp, bottom = 52.dp),
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    TextButton(
                        onClick = { /*TODO*/ }
                    ) {
                        Text(
                            text = "Clear",
                            style = TextStyle(
                                color = Color.Transparent,
                            )
                        )
                    }

                    Text(
                        text = "Filtros",
                        style = TextStyle(
                            fontSize = 18.sp,
                            lineHeight = 28.sp,
                            fontWeight = FontWeight(700),
                            color = Color(0xFF44403C),
                        )
                    )

                    TextButton(
                        onClick = { /*TODO*/ }
                    ) {
                        Text(
                            text = "Clear",
                            style = TextStyle(
                                fontSize = 16.sp,
                                lineHeight = 24.sp,
                                fontWeight = FontWeight(500),
                                color = Color(0xFFFF7930),
                            )
                        )
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                Text(
                    text = "Interesses",
                    style = TextStyle(
                        fontSize = 16.sp,
                        lineHeight = 24.sp,
                        fontWeight = FontWeight(500),
                        color = Color(0xFF57534E),
                    ),
                    modifier = Modifier
                        .padding(bottom = 12.dp)
                )

                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    modifier = Modifier,
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    items(interessesList) {
                        var selected = interessesSelecionados.contains(it)

                        FilterChip(
                            selected = selected,
                            onClick = {
                                if (selected) {
                                    bottomSheetViewModel.onRemoveInteresse(it)
                                } else {
                                    bottomSheetViewModel.onAddInteresse(it)
                                }
                            },
                            label = {
                                Text(
                                    text = it,
                                    modifier = Modifier
                                        .padding(vertical = 4.dp),
                                )
                            },
                            modifier = Modifier,
                            colors = FilterChipDefaults.filterChipColors(
                                containerColor = Color(0xFFF1E8DA),
                                selectedContainerColor = Color(0xFFFF7930),
                                labelColor = Color(0xFF000000),
                                selectedLabelColor = Color(0xFFF1E8DA),
                            ),
                            border = null,
                            elevation = FilterChipDefaults.elevatedFilterChipElevation(
                                elevation = 2.dp
                            )
                        )
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                Column(

                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Distância",
                            style = TextStyle(
                                fontSize = 20.sp,
                                lineHeight = 28.sp,
                                fontWeight = FontWeight(700),
                                color = Color(0xFF292524),
                            )
                        )

                        Text(
                            text = "$distance km",
                            style = TextStyle(
                                fontSize = 14.sp,
                                lineHeight = 21.sp,
                                fontWeight = FontWeight(500),
                                color = Color(0xFF44403C),

                                )
                        )
                    }

                    Slider(
                        value = distance,
                        onValueChange = { bottomSheetViewModel.onDistanceChange(it) },
                        colors = SliderDefaults.colors(
                            thumbColor = Color(0xFFFF7930),
                            activeTrackColor = Color(0xFFFF7930),
                            inactiveTrackColor = Color(0xFFDDDBDF),
                        ),
                        steps = 9,
                        valueRange = 0f..100f,
                        thumb = {
                            Box(
                                modifier = Modifier
                                    .border(width = 4.dp, color = Color(0xFFFFFFFF))
                                    .padding(4.dp)
                                    .width(32.dp)
                                    .height(32.dp)
                                    .background(color = Color(0xFFFF7930), shape = CircleShape)
                            ) {}
                        },
                    )
                }

                Spacer(modifier = Modifier.height(24.dp))

                ElevatedButton(
                    onClick = { /*TODO*/ },
                    modifier = Modifier
                        .fillMaxWidth(),
                    colors = ButtonDefaults.elevatedButtonColors(
                        containerColor = Color(0xFFFF7930),
                        contentColor = Color(0xFFF1E8DA)
                    ),
                ) {
                    Text(text = "Aplicar")
                }
            }
        }
    }
}