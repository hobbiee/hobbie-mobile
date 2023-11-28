package com.example.hobbie.ui.screens.authentication

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.NavController

@Composable
fun MultiFormSignUp(
    navController: NavController,
    email: String,
    onEmailChange: (String) -> Unit,
    onContinueClick: () -> Unit
) {
    val emailError = remember { mutableStateMapOf<String, String>() }
    val emailErrorState = remember { mutableStateOf(false) }
}