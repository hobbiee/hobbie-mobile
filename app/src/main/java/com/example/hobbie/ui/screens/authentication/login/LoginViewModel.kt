package com.example.hobbie.ui.screens.authentication.login

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.hobbie.api.HobbieAPI
import com.example.hobbie.api.session.SessionManager
import com.example.hobbie.models.http.LoginRequest
import com.example.hobbie.models.http.LoginResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val hobbieAPI: HobbieAPI,
    private val sessionManager: SessionManager
) : ViewModel() {
    var hasError: Boolean by mutableStateOf(false)
        private set
    var email by mutableStateOf("")
        private set
    var password by mutableStateOf("")
    var errorMessage by mutableStateOf("")
        private set

    fun onEmailChange(email: String) {
        this.hasError = false
        this.email = email
    }

    fun onPasswordChange(password: String) {
        this.hasError = false
        this.password = password
    }

    fun onLoginClick(onLoginSuccess: () -> Unit) {

        if (isValid()) {
            hobbieAPI
                .doLogin(LoginRequest(email, password))
                .enqueue(object : Callback<LoginResponse> {
                    override fun onResponse(
                        call: Call<LoginResponse>,
                        response: Response<LoginResponse>
                    ) {
                        if (response.isSuccessful) {
                            Log.d("Login Success", "onResponse: ${response.body()}")
                            sessionManager.saveAuthToken(response.body()!!.accessToken)
                            onLoginSuccess()
                        } else {
                            Log.d("Login Error", "onResponse: ${response.errorBody()}")
                            errorMessage = "Usuário ou senha inválidos"
                            hasError = true
                        }
                    }

                    override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                        errorMessage = "Erro ao fazer login, tente novamente mais tarde"
                        hasError = true
                    }

                })

            return
        }

        when {
            email.isEmpty() -> {
                errorMessage = "Email não pode ser vazio"
                this.hasError = true
            }

            !email.contains("@") || !email.contains(".") -> {
                errorMessage = "Email inválido"
                this.hasError = true
            }

            password.isEmpty() -> {
                errorMessage = "Senha não pode ser vazia"
                this.hasError = true
            }
        }
    }

    private fun isValid(): Boolean {
        return email.isNotEmpty() &&
                email.contains("@") &&
                email.contains(".")
                && password.isNotEmpty()
    }
}