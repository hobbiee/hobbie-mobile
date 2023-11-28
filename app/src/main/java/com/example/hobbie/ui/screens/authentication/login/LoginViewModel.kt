package com.example.hobbie.ui.screens.authentication.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.hobbie.api.HobbieAPI
import com.example.hobbie.models.http.LoginRequest
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val hobbieAPI: HobbieAPI
) : ViewModel() {
    var email by mutableStateOf("")
        private set
    var password by mutableStateOf("")

    fun onEmailChange(email: String) {
        this.email = email
    }

    fun onPasswordChange(password: String) {
        this.password = password
    }

    fun onLoginClick() {
        if (isValid()) {
            hobbieAPI.doLogin(LoginRequest(email, password))
        }
    }

    private fun isValid(): Boolean {
        return email.isNotEmpty() &&
                email.contains("@") &&
                email.contains(".")
                && password.isNotEmpty()
    }
}