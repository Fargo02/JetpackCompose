package com.example.jetpackcompose

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcompose.ui.theme.Grey
import com.example.jetpackcompose.ui.theme.Grey40
import com.example.jetpackcompose.ui.theme.interFamily

@Composable
fun Toolbar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        Column(){
            Text(text = "Текущее местоположение",
                color = Grey,
                fontSize = 12.sp,
                fontFamily = interFamily,
                fontWeight = FontWeight.Normal,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Row(){
                Image(painter = painterResource(R.drawable.location), contentDescription = "location")
                Text(text = "Красноярcк, Россия",
                    fontSize = 14.sp,
                    fontFamily = interFamily,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.offset(x = 8.dp)
                )
            }
        }
        Button(onClick = { },
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.White, contentColor = Color.Black),
            border = BorderStroke(1.dp, Grey),
            contentPadding = PaddingValues(0.dp),

            ) {
            Icon(
                painter = painterResource(R.drawable.notification),
                contentDescription = "notification",
                modifier = Modifier.size(24.dp)
            )
        }
    }
}