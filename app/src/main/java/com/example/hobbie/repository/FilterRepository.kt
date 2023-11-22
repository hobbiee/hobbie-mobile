package com.example.hobbie.repository

import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import javax.inject.Inject

class FilterRepository @Inject constructor(
    private val savedStateHandle: SavedStateHandle
)  {
    val interessesList: List<String> = listOf(
        "Corrida",
        "Futebol",
        "Natacao",
        "Basquete",
        "Outros"
    )

    private var _isBottomSheetOpen = mutableStateOf(false)

    val isBottomSheetOpen = _isBottomSheetOpen

    private var _interressesSelecionados = mutableStateListOf<String>()

    val interessesSelecionados = _interressesSelecionados

    private var _distance = mutableFloatStateOf(40f)

    val distance = _distance

    fun onAddInteresse(interresse: String) {
        _interressesSelecionados.add(interresse)
    }

    fun onRemoveInteresse(interresse: String) {
        _interressesSelecionados.remove(interresse)
    }

    fun onDistanceChange(distance: Float) {
        _distance.value = distance
    }

    fun onChangeBottomSheetState() {
        val newBottomSheetState =  _isBottomSheetOpen.value.not()
        _isBottomSheetOpen.value = newBottomSheetState
        savedStateHandle["isBottomSheetOpen"] = newBottomSheetState

        println(savedStateHandle.get<Boolean>("isBottomSheetOpen"))
    }
}