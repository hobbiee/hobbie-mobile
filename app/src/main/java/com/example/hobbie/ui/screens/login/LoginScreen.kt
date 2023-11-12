package com.example.hobbie.ui.screens.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.hobbie.R
import com.example.hobbie.ui.Destinations

@Composable
fun ShouldRegisterScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFFF1E8DA))
            .padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
//                .background(color = Color(0xFFFFFFFF))
                .padding(0.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "HOBBIE",
                style = TextStyle(
                    fontSize = 48.sp,
                    fontWeight = FontWeight(700),
                    color = Color(0xFF000000),
                )
            )

            Image(
                painter = painterResource(id = R.drawable.hobbie_logo),
                contentDescription = "Logo",
                modifier = Modifier
                    // preciso que tenho o tamanho dinamico
                    .fillMaxWidth()
            )
        }





        Column(
            modifier = Modifier,
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            OutlinedButton(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.outlinedButtonColors(
                    containerColor = Color(0xFFFFFFFF),
                ),
                modifier = Modifier
                    .fillMaxWidth(),
            ) {
                Text(
                    text = "Entrar com Google",
                    style = TextStyle(
                        fontSize = 20.sp,
                        lineHeight = 28.sp,
                        fontWeight = FontWeight(700),
                        color = Color(0x80020000),
                        textAlign = TextAlign.Center,
                    )
                )
            }


            OutlinedButton(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.outlinedButtonColors(
                    containerColor = Color(0xFF1877F2),
                ),
                modifier = Modifier
                    .fillMaxWidth(),
                border = null
            ) {
                Text(
                    text = "Entrar com Facebook",
                    style = TextStyle(
                        fontSize = 20.sp,
                        lineHeight = 28.sp,
                        fontWeight = FontWeight(700),
                        color = Color(0xFFFFFFFF),
                        textAlign = TextAlign.Center,
                    )
                )
            }


            OutlinedButton(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.outlinedButtonColors(
                    containerColor = Color(0xFF000000),
                ),
                modifier = Modifier
                    .fillMaxWidth(),
                border = null
            ) {
                Text(
                    text = "Entrar com Email",
                    style = TextStyle(
                        fontSize = 20.sp,
                        lineHeight = 28.sp,
                        fontWeight = FontWeight(700),
                        color = Color(0xFFFFFFFF),
                        textAlign = TextAlign.Center,
                    )
                )
            }
        }




        Spacer(
            modifier = Modifier.height(26.dp)
        )

        Row(
            modifier = Modifier
                .fillMaxWidth(),
        ) {
            Divider(
                modifier = Modifier
                    .weight(1f)
                    .padding(8.dp),
                color = Color(0x80020000),
                thickness = 0.5.dp
            )

            Text(
                text = "ou crie sua conta",
                // text-xs/leading-4/font-bold
                style = TextStyle(
                    fontSize = 12.sp,
                    lineHeight = 16.sp,
                    fontWeight = FontWeight(700),
                    color = Color(0x80020000),

                    textAlign = TextAlign.Center,
                )
            )

            Divider(
                modifier = Modifier
                    .weight(1f)
                    .padding(8.dp),
                color = Color(0x80020000),
                thickness = 0.5.dp
            )
        }

        Spacer(
            modifier = Modifier.height(26.dp)
        )

        Row(
//            horizontalArrangement = Arrangement.Center,
//            verticalAlignment = Alignment.CenterVertically
        ){
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier,
                shape = RoundedCornerShape(0.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFFFFFFF)
                ),
            ) {

            }
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    navController: NavController
) {

    var textFieldValue by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFFF1E8DA))
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        Column(
            modifier = Modifier
                .fillMaxWidth()
//                .background(color = Color(0xFFFFFFFF))
                .padding(0.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "HOBBIE",
                style = TextStyle(
                    fontSize = 36.sp,
                    fontWeight = FontWeight(700),
                    color = Color(0xFF000000),
                )
            )

            Image(
                painter = painterResource(id = R.drawable.hobbie_logo),
                contentDescription = "Logo",
                modifier = Modifier
                    // preciso que tenho o tamanho dinamico
                    .fillMaxWidth()
            )
        }




        Column (
            verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            Text(
                text = "E-mail *",
                // text-sm/leading-5/font-medium
                style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 20.sp,
                    fontWeight = FontWeight(500),
                )
            )

            OutlinedTextField(
                value = textFieldValue,
                onValueChange = { textFieldValue = it },
                modifier = Modifier
                    .fillMaxWidth(),
                placeholder = { Text("Digite seu email aqui") },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    unfocusedBorderColor = Color(0xFF262626)
                ),
            )

        }

        Spacer(
            modifier = Modifier.height(32.dp)
        )

        Column (
            verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            Text(
                text = "Senha *",
                // text-sm/leading-5/font-medium
                style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 20.sp,
                    fontWeight = FontWeight(500),
                )
            )

            OutlinedTextField(
                value = textFieldValue,
                onValueChange = { textFieldValue = it },
                modifier = Modifier
                    .fillMaxWidth(),
                placeholder = { Text("Digite seu senha aqui") },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    unfocusedBorderColor = Color(0xFF262626)
                ),
            )

        }


        Button(
            onClick = {
                navController.navigate("root_graph/home_graph")
            },
            modifier = Modifier
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF292524)
            )
        ) {
            Text(text = "Entrar")
        }
    }
}

