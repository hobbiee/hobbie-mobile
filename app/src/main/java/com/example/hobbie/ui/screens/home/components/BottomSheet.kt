package com.example.hobbie.ui.screens.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilterChip
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.mutableFloatStateOf
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.hobbie.ui.screens.home.HomeViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheet() {
    val homeViewModel: HomeViewModel = viewModel()

    val isBottomSheetOpen = homeViewModel.isBottomSheetOpen.value

    val sheetState = rememberModalBottomSheetState()

    if(isBottomSheetOpen) {
        ModalBottomSheet(
            onDismissRequest = {
                homeViewModel.onChangeBottomSheetState()
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
                        .fillMaxWidth()
                        .padding(bottom = 32.dp),
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

                val interessesList: List<String> = listOf(
                    "Corrida",
                    "Futebol",
                    "Natacao",
                    "Basquete",
                    "Outros"
                )

                var interessesSelecionados = remember { mutableStateListOf<String>() }

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
                                    interessesSelecionados.remove(it)
                                } else {
                                    interessesSelecionados.add(it)
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

                val context = LocalContext.current
                val coffeeDrinks = arrayOf("Americano", "Cappuccino", "Espresso", "Latte", "Mocha")
                var expanded by remember { mutableStateOf(false) }
                var selectedText by remember { mutableStateOf(coffeeDrinks[0]) }


                Box(
                    modifier = Modifier
                        .fillMaxWidth(),
                ) {
                    ExposedDropdownMenuBox(
                        expanded = expanded,
                        onExpandedChange = {
                            expanded = !expanded
                        }
                    ) {
                        OutlinedTextField(
                            value = selectedText,
                            onValueChange = {},
                            readOnly = true,
                            trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                            modifier = Modifier
                                .menuAnchor()
                                .fillMaxWidth(),
                            label = { Text("Localidade") },
                            shape = RoundedCornerShape(12.dp),
                        )

                        ExposedDropdownMenu(
                            expanded = expanded,
                            onDismissRequest = { expanded = false }
                        ) {
                            coffeeDrinks.forEach { item ->
                                DropdownMenuItem(
                                    text = { Text(text = item) },
                                    onClick = {
                                        selectedText = item
                                        expanded = false
                                    }
                                )
                            }
                        }
                    }
                }

                var distancia by remember { mutableFloatStateOf(40f) }

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
                            text = "$distancia km",
                            style = TextStyle(
                                fontSize = 14.sp,
                                lineHeight = 21.sp,
                                fontWeight = FontWeight(500),
                                color = Color(0xFF44403C),

                                )
                        )
                    }

                    Slider(
                        value = distancia,
                        onValueChange = { distancia = it },
                        colors = SliderDefaults.colors(

                        ),
                        steps = 1,
                        valueRange = 0f..100f
                    )
                }



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
