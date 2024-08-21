package com.example.hotelmanagement.ui.theme.screens.home


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.hotelmanagement.R
import com.example.hotelmanagement.ui.theme.Pink


@Composable
fun HomeScreen(navController: NavController){
        Column (modifier = Modifier
            .fillMaxSize()
            .background(Pink),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
            ){

            Text(
                text = "Hotel Management",
                fontSize = 40.sp,
                fontFamily = FontFamily.Default,
                color = Color.Blue

            )

            Spacer(modifier = Modifier.height(40.dp))


            Image(
                painter = painterResource(id = R.drawable.img_4),
                contentDescription = "home",
                modifier = Modifier
                    .size(200.dp)
                    .clip(shape = CircleShape),
                contentScale = ContentScale.Crop



            )



            Spacer(modifier = Modifier.height(40.dp))

                Text(
                       text = "Your better choice",
                        fontSize = 20.sp
                     )
                     Spacer(modifier = Modifier.height(40.dp))





        }
        

}

@Composable
@Preview(showBackground = true)
fun HomeScreenPreview(){
        HomeScreen(rememberNavController())

}

