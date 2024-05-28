package com.example.jetpackcompose

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcompose.ui.theme.Blue
import com.example.jetpackcompose.ui.theme.Grey
import com.example.jetpackcompose.ui.theme.Grey40
import com.example.jetpackcompose.ui.theme.GreyLight
import com.example.jetpackcompose.ui.theme.interFamily
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

@Composable
fun CategoryItem(item: ItemCategory){
    val backgroundColor = remember {
        mutableStateOf(Color.White)
    }
    val contentColor = remember {
        mutableStateOf(Grey)
    }
    Button(onClick =
    {
        if(backgroundColor.value == Color.White) {
            backgroundColor.value = Blue
            contentColor.value = Color.White
        }
        else {
            backgroundColor.value = Color.White
            contentColor.value = Grey
        }
                     },
        shape = RoundedCornerShape(12.dp),
        border = BorderStroke(1.dp, GreyLight),
        colors = ButtonDefaults.buttonColors(containerColor = backgroundColor.value, contentColor = contentColor.value),
        contentPadding = PaddingValues(start = 12.dp, top = 8.dp, bottom = 8.dp, end = 18.dp),
        modifier = Modifier.padding(start = 8.dp, end = 8.dp)
        ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(
                painter = painterResource(item.image),
                contentDescription = "notification",
                modifier = Modifier
                    .size(24.dp)
            )
            Text(text = item.title,
                fontSize = 14.sp,
                fontFamily = interFamily,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.offset(x = 6.dp)
            )
        }
    }
}

@Composable
fun Category() {
    LazyRow(
        modifier = Modifier.fillMaxWidth().background(Color.Red),
        contentPadding = PaddingValues(8.dp)

    ){
        itemsIndexed(
            listOf(
                ItemCategory("Отель", R.drawable.hotel),
                ItemCategory("Homestay", R.drawable.homestay),
                ItemCategory("Квартира", R.drawable.apart),
                ItemCategory("Дом", R.drawable.house)
            )
        ){
                _, item ->
            CategoryItem(
                item = item,
            )
        }
    }
}