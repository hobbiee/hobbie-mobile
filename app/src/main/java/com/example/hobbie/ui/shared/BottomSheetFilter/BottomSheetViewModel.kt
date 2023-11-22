package com.example.hobbie.ui.shared.BottomSheetFilter

import androidx.lifecycle.ViewModel
import com.example.hobbie.repository.FilterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BottomSheetViewModel @Inject constructor(
    private val filterRepository: FilterRepository
) : ViewModel() {
    val interessesList: List<String> = filterRepository.interessesList

    val interessesSelecionados = filterRepository.interessesSelecionados

    val distance = filterRepository.distance

    fun onAddInteresse(interresse: String) {
        filterRepository.onAddInteresse(interresse)
    }

    fun onRemoveInteresse(interresse: String) {
        filterRepository.onRemoveInteresse(interresse)
    }

    fun onDistanceChange(distance: Float) {
        filterRepository.onDistanceChange(distance)
    }
}