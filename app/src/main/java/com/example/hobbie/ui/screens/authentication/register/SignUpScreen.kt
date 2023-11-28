package com.example.hobbie.ui.screens.authentication.register

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import coil.compose.rememberAsyncImagePainter
import com.example.hobbie.R
import com.example.hobbie.ui.theme.Primary
import com.example.hobbie.ui.theme.Secondary
import com.example.hobbie.ui.theme.WarmGray500
import com.example.hobbie.ui.theme.WarmGray800

@Composable
fun SignUpScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Primary)
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painter = rememberAsyncImagePainter(model = "https://hobbie.s3.amazonaws.com/hobbie/hobbie_logo_no_bg.png"),
            contentDescription = "Logo",
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.5f)
        )

        Spacer(modifier = Modifier.height(48.dp))

        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(32.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                OutlinedButton(
                    onClick = {
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(52.dp),
                    border = BorderStroke(2.dp, WarmGray800),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White
                    ),
                    shape = MaterialTheme.shapes.large
                ) {
                    // google icon
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_google),
                            contentDescription = "Google Icon",
                            modifier = Modifier
                                .absoluteOffset(x = (-24).dp, y = 0.dp)
                        )

                        Text(
                            text = "Entrar com o Google",
                            style = TextStyle(
                                fontSize = 20.sp,
                                lineHeight = 26.sp,
                                fontWeight = FontWeight(600),
                                fontFamily = MaterialTheme.typography.bodyMedium.fontFamily,
                                color = WarmGray500
                            ),
                            textAlign = TextAlign.Center,
                        )
                    }
                }

                Button(
                    onClick = { navController.navigate("sign_in") },
                    shape = MaterialTheme.shapes.large,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(52.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Black
                    )
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            Icons.Filled.Email,
                            contentDescription = "Email Icon",
                            modifier = Modifier
                                .absoluteOffset(x = (-32).dp, y = 0.dp)
                                .size(32.dp)
                        )

                        Text(
                            text = "Entrar com o Email",
                            style = TextStyle(
                                fontSize = 20.sp,
                                lineHeight = 26.sp,
                                fontWeight = FontWeight(600),
                                fontFamily = MaterialTheme.typography.bodyMedium.fontFamily,
                                color = Color.White
                            ),
                            textAlign = TextAlign.Center,
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(48.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // divider
            Spacer(
                modifier = Modifier
                    .height(1.dp)
                    .background(color = WarmGray500)
                    .fillMaxWidth(0.3f)
            )

            Text(
                text = "ou crie sua conta",
                style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 20.sp,
                    fontWeight = FontWeight(500),
                    fontFamily = MaterialTheme.typography.bodyLarge.fontFamily,
                    color = WarmGray800
                ),
            )

            // divider
            Spacer(
                modifier = Modifier
                    .height(1.dp)
                    .background(color = WarmGray500)
                    .fillMaxWidth(0.8f)
            )
        }

        Spacer(modifier = Modifier.height(48.dp))

        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = { /*TODO*/ },
                shape = MaterialTheme.shapes.large,
                modifier = Modifier
                    .width(72.dp)
                    .align(Alignment.CenterVertically)
                    .height(72.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White
                ),
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.google),
                    contentDescription = "Email Icon",
                    modifier = Modifier
                        .fillMaxSize(),
                    tint = Secondary
                )
            }

            Button(
                onClick = { /*TODO*/ },
                shape = MaterialTheme.shapes.large,
                modifier = Modifier
                    .width(72.dp)
                    .align(Alignment.CenterVertically)
                    .height(72.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.White
                ),
            ) {
                Icon(
                    // google icon
                    Icons.Filled.Email,
                    contentDescription = "Email Icon",
                    modifier = Modifier
                        .fillMaxSize(),
                    tint = Secondary,
                )
            }
        }
    }
}