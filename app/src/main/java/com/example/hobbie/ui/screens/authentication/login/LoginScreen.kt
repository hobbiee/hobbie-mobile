package com.example.hobbie.ui.screens.authentication.login

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.hobbie.R
import com.example.hobbie.ui.navigation.graphs.Graph
import com.example.hobbie.ui.theme.Error
import com.example.hobbie.ui.theme.Primary
import com.example.hobbie.ui.theme.WarmGray100
import com.example.hobbie.ui.theme.WarmGray800

@Composable
fun LoginScreen(
    navController: NavController
) {
    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp
    val loginViewModel: LoginViewModel = hiltViewModel()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFFF1E8DA))
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            Icons.Rounded.ArrowBack,
            contentDescription = "Arrow Forward",
            modifier = Modifier
                // dynamically set the offset to the end of the screen
                .absoluteOffset(x = (-screenWidth / 2 + 32.dp), y = 0.dp)
                .size(72.dp)
                .padding(16.dp)
                .background(color = Primary, shape = MaterialTheme.shapes.extraLarge)
                .border(
                    BorderStroke(2.dp, WarmGray800),
                    shape = MaterialTheme.shapes.extraLarge
                )
                .padding(8.dp)
                .clickable { navController.popBackStack() }
        )


        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.hobbie_logo_no_bg),
                contentDescription = "Logo",
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.5f)
            )
        }


        Column(
            modifier = Modifier
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(32.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(24.dp)
            ) {
                EmailTextField(emailState = loginViewModel.email) {
                    loginViewModel.onEmailChange(it)
                }
                PasswordTextField(passwordState = loginViewModel.password) {
                    loginViewModel.onPasswordChange(it)
                }
            }

            if (loginViewModel.hasError) {
                Text(
                    text = loginViewModel.errorMessage,
                    style = TextStyle(
                        fontSize = 14.sp,
                        lineHeight = 20.sp,
                        fontWeight = FontWeight(500),
                        fontFamily = MaterialTheme.typography.bodyLarge.fontFamily,
                        color = Error
                    ),
                    textAlign = TextAlign.Center,
                )
            }

            Button(
                onClick = {
                    loginViewModel.onLoginClick() {
                        navController.navigate(Graph.HOME)
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = WarmGray800
                ),
            ) {

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Entrar",
                        style = TextStyle(
                            fontSize = 16.sp,
                            lineHeight = 20.sp,
                            fontWeight = FontWeight(500),
                            fontFamily = MaterialTheme.typography.bodyLarge.fontFamily,
                            color = WarmGray100
                        ),
                        textAlign = TextAlign.Center,
                    )

                    Icon(
                        Icons.Filled.ArrowForward,
                        contentDescription = "Arrow Forward",
                        modifier = Modifier
                            .absoluteOffset(x = 120.dp, y = 0.dp)
                    )
                }
            }
        }


    }
}

@Composable
fun EmailTextField(
    emailState: String,
    onEmailChange: (String) -> Unit = {}
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(
                text = "E-mail",
                style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 20.sp,
                    fontWeight = FontWeight(500),
                    fontFamily = MaterialTheme.typography.bodyLarge.fontFamily
                )
            )

            Text(
                text = "*",
                style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 20.sp,
                    fontWeight = FontWeight(500),
                    fontFamily = MaterialTheme.typography.bodyLarge.fontFamily,
                    color = Color(0xFFEF4444)
                )
            )
        }

        OutlinedTextField(
            value = emailState,
            onValueChange = {
                onEmailChange(it)
            },
            modifier = Modifier
                .fillMaxWidth(),
            textStyle = TextStyle(
                fontSize = 14.sp,
                lineHeight = 20.sp,
                fontWeight = FontWeight(500),
                fontFamily = MaterialTheme.typography.bodyLarge.fontFamily
            ),
            singleLine = true,
            placeholder = { Text("Digite seu email aqui") },
            colors = OutlinedTextFieldDefaults.colors(
                cursorColor = Color(0xFF000000),
                focusedBorderColor = Color(0xFF000000),
                unfocusedBorderColor = Color(0xFF000000),
            )
        )

    }
}

@Composable
fun PasswordTextField(
    passwordState: String,
    onPasswordChange: (String) -> Unit = {}
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(
                text = "Senha",
                style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 20.sp,
                    fontWeight = FontWeight(500),
                    fontFamily = MaterialTheme.typography.bodyLarge.fontFamily
                )
            )

            Text(
                text = "*",
                style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 20.sp,
                    fontWeight = FontWeight(500),
                    fontFamily = MaterialTheme.typography.bodyLarge.fontFamily,
                    color = Color(0xFFEF4444)
                )
            )
        }

        OutlinedTextField(
            value = passwordState,
            onValueChange = {
                onPasswordChange(it)
            },
            modifier = Modifier
                .fillMaxWidth(),
            textStyle = TextStyle(
                fontSize = 14.sp,
                lineHeight = 20.sp,
                fontWeight = FontWeight(500),
                fontFamily = MaterialTheme.typography.bodyLarge.fontFamily
            ),
            singleLine = true,
            placeholder = { Text("Digite sua senha aqui") },
            colors = OutlinedTextFieldDefaults.colors(
                cursorColor = Color(0xFF000000),
                focusedBorderColor = Color(0xFF000000),
                unfocusedBorderColor = Color(0xFF000000),
            ),
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        )

    }
}
