package com.example.hobbie.ui.screens.home

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class HomeViewModel: ViewModel() {

    // MUTABLE STATE

    private var _isBottomSheetOpen = mutableStateOf(false)

    val isBottomSheetOpen = _isBottomSheetOpen

    fun onChangeBottomSheetState() {
        _isBottomSheetOpen.value = _isBottomSheetOpen.value.not()
    }

//    fun onBottomSheetOpen() {
//        Log.d("HomeViewModel", "onBottomSheetOpen: ")
//        _isBottomSheetOpen.value = true
//    }
//
//    fun onBottomSheetClose(): () -> Unit = {
//        _isBottomSheetOpen.value = false
//    }





//     MUTABLE LIVE DATA

//    private val _isBottomSheetOpen = MutableLiveData(false)
//
//    val isBottomSheetOpen: LiveData<Boolean> get() = _isBottomSheetOpen
//
//    fun onBottomSheetOpen() {
//        Log.d("HomeViewModel", "onBottomSheetOpen: ")
//        _isBottomSheetOpen.value = _isBottomSheetOpen.value?.not()
//    }





//    private val _isBottomSheetOpen = MutableStateFlow(true)
//
//    val isBottomSheetOpen: StateFlow<Boolean> get() = _isBottomSheetOpen
//
//    suspend fun onBottomSheetOpen() {
//        Log.d("HomeViewModel", "onBottomSheetOpen: ")
//        _isBottomSheetOpen.emit(_isBottomSheetOpen.value.not())
//    }


}