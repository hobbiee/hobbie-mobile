package com.example.hobbie.ui.screens.event.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hobbie.models.EventItem
import com.google.android.gms.maps.model.LatLng

@Composable
fun BottomSheet(
    event: EventItem
) {
    Column(
        modifier = Modifier
            .padding(top = 0.dp, bottom = 16.dp, start = 24.dp, end = 24.dp)
    ) {
        Text(
            text = event.name,
            style = TextStyle(
                fontSize = 24.sp,
                lineHeight = 32.sp,
                fontWeight = FontWeight(700),
                color = Color(0xFF3F3F46),
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "LAT: ${event.latitude}  ${event.longitude}",
                style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 20.sp,
                    fontWeight = FontWeight(500),
                    color = Color(0xFF78716C),
                )
            )

            Text(
                text = "${event.distance}km",
                style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 20.sp,
                    fontWeight = FontWeight(500),
                    color = Color(0xFFA8A29E),
                )
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        Box(
            modifier = Modifier
                .background(color = Color(0xFFFF7930), shape = RoundedCornerShape(percent = 100))

        ) {
            Text(
                text = event.capacity.toString(),
                style = TextStyle(
                    fontSize = 12.sp,
                    lineHeight = 16.sp,
                    fontWeight = FontWeight(700),
                    color = Color(0xFFFFFFFF),
                ),
                modifier = Modifier
                    .padding(vertical = 4.dp, horizontal = 8.dp)
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        Box(
            Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(color = Color(0xFFE5E7EB))
        )

        Spacer(modifier = Modifier.height(12.dp))

        Column(
            modifier = Modifier
        ) {
            Text(
                text = "Descrição",
                style = TextStyle(
                    fontSize = 18.sp,
                    lineHeight = 28.sp,
                    fontWeight = FontWeight(500),
                    color = Color(0xFF57534E),
                )
            )

            Text(
                text = event.description,
                style = TextStyle(
                    fontSize = 14.sp,
                    lineHeight = 20.sp,
                    fontWeight = FontWeight(450),
                    color = Color(0xFF404040),
                )
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        Column(

        ) {
            Text(
                text = "Horário",
                style = TextStyle(
                    fontSize = 18.sp,
                    lineHeight = 28.sp,
                    fontWeight = FontWeight(500),
                    color = Color(0xFF57534E),
                )
            )

            Text(
                text = "${event.startTime} - ${event.endTime}",
                style = TextStyle(
                    fontSize = 16.sp,
                    lineHeight = 24.sp,
                    fontWeight = FontWeight(450),
                    color = Color(0xFF292524),
                )
            )
        }

        Spacer(modifier = Modifier.height(12.dp))

        Box(
            Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(color = Color(0xFFE5E7EB))
        )

        Spacer(modifier = Modifier.height(12.dp))

        Column(

        ) {
            Text(
                text = "Localização",
                style = TextStyle(
                    fontSize = 18.sp,
                    lineHeight = 28.sp,
                    fontWeight = FontWeight(500),
                    color = Color(0xFF57534E),
                )
            )

            Spacer(modifier = Modifier.height(8.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
                    .shadow(4.dp, shape = RoundedCornerShape(8.dp))
            ) {
                MapSnippet(
                    latLng = LatLng(
                        event.latitude,
                        event.longitude
                    )
                )
            }
        }

        Spacer(modifier = Modifier.height(64.dp))
    }
}