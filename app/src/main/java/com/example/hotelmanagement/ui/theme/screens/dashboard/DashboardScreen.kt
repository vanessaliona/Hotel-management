package com.example.hotelmanagement.ui.theme.screens.dashboard

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.hotelmanagement.R
import com.example.hotelmanagement.navigation.ROUT_DRINK
import com.example.hotelmanagement.navigation.ROUT_ENTERTAINMENT
import com.example.hotelmanagement.navigation.ROUT_HOTEL
import com.example.hotelmanagement.navigation.ROUT_INTENT
import com.example.hotelmanagement.navigation.ROUT_MAP
import com.example.hotelmanagement.navigation.ROUT_ROOM
import com.example.hotelmanagement.navigation.VIEW_MENU_URL
import com.example.hotelmanagement.navigation.VIEW_ROOM_URL
import com.example.hotelmanagement.ui.theme.Pink
import com.example.hotelmanagement.ui.theme.newPink1

@Composable
fun DashboardScreen(navController: NavController) {

    Column(
        modifier = Modifier.fillMaxSize()
            .background(newPink1),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {

        Spacer(modifier = Modifier.height(30.dp))
        Image(
            painter = painterResource(id = R.drawable.img_5),
            contentDescription = "Home",
            modifier = Modifier
                .size(200.dp),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "We are delighted to have you with us",
            fontSize = 25.sp,
            fontFamily = FontFamily.Default,
            textAlign = TextAlign.Center

        )
        Spacer(modifier = Modifier.height(10.dp))

        Column (modifier = Modifier.verticalScroll(rememberScrollState())){
            //Start of main card
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(700.dp),
                shape = RoundedCornerShape(topStart = 60.dp, topEnd = 60.dp),
                colors = CardDefaults.cardColors(Pink)
            ) {
                //Row1
                Row(modifier = Modifier.padding(20.dp)) {
                    //Card
                    Card(modifier = Modifier
                        .width(160.dp)
                        .height(200.dp)
                        .clickable { navController.navigate(ROUT_HOTEL) },
                        colors = CardDefaults.cardColors(newPink1)) {
                        Column {
                            Spacer(modifier = Modifier.height(15.dp))

                            Box(
                                modifier = Modifier.fillMaxWidth(),
                                contentAlignment = Alignment.Center
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.img_13),
                                    contentDescription = "Home",
                                    modifier = Modifier.size(130.dp)
                                        .clip(CircleShape),
                                    contentScale = ContentScale.Crop
                                )
                            }
                            Spacer(modifier = Modifier.height(15.dp))

                            Text(
                                text = "Hotels",
                                fontSize = 20.sp,
                                modifier = Modifier.fillMaxWidth(),
                                textAlign = TextAlign.Center,
                                fontWeight = FontWeight.ExtraBold

                            )
                        }


                    }
                    //End of card

                    Spacer(modifier = Modifier.width(20.dp))

                    //Card
                    Card(modifier = Modifier
                        .width(160.dp)
                        .height(200.dp)
                        .clickable { navController.navigate(VIEW_MENU_URL) },
                        colors = CardDefaults.cardColors(newPink1)
                    ) {
                        Column {
                            Spacer(modifier = Modifier.height(20.dp))

                            Box(
                                modifier = Modifier.fillMaxWidth(),
                                contentAlignment = Alignment.Center
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.img_27),
                                    contentDescription = "Hotel",
                                    modifier = Modifier.size(130.dp)
                                        .clip(CircleShape),
                                    contentScale = ContentScale.Crop
                                )
                            }
                            Spacer(modifier = Modifier.height(15.dp))

                            Text(
                             text = "Menu",
                                fontSize = 18.sp,
                                modifier = Modifier.fillMaxWidth(),
                                textAlign = TextAlign.Center,
                                fontWeight = FontWeight.ExtraBold



                                )

                        }


                    }
                    //End of card
                       
                }
                //End of Row
                        Spacer(modifier = Modifier.width(20.dp))
                //Row1
                Row(modifier = Modifier.padding(20.dp)) {
                    //Card
                    Card(modifier = Modifier
                        .width(160.dp)
                        .height(200.dp)
                        .clickable { navController.navigate(ROUT_MAP) },
                        colors = CardDefaults.cardColors(newPink1)) {
                        Column {
                            Spacer(modifier = Modifier.height(15.dp))

                            Box(
                                modifier = Modifier.fillMaxWidth(),
                                contentAlignment = Alignment.Center
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.img_30),
                                    contentDescription = "",
                                    modifier = Modifier.size(130.dp)

                                )
                            }
                            Spacer(modifier = Modifier.height(15.dp))

                            Text(
                                text = "Location",
                                fontSize = 18.sp,
                                modifier = Modifier.fillMaxWidth(),
                                textAlign = TextAlign.Center,
                                fontWeight = FontWeight.ExtraBold


                            )
                        }


                    }
                    //End of card

                        Spacer(modifier = Modifier.width(20.dp))

                    //Card
                    Card(modifier = Modifier
                        .width(160.dp)
                        .height(200.dp)
                        .clickable { navController.navigate(VIEW_ROOM_URL ) },
                        colors = CardDefaults.cardColors(newPink1)) {
                        Column {
                            Spacer(modifier = Modifier.height(20.dp))

                            Box(
                                modifier = Modifier.fillMaxWidth(),
                                contentAlignment = Alignment.Center
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.img_8),
                                    contentDescription = "Rooms",
                                    modifier = Modifier.size(130.dp)
                                        .clip(CircleShape),
                                    contentScale = ContentScale.Crop
                                )
                            }
                            Spacer(modifier = Modifier.height(15.dp))

                            Text(
                                text = "Rooms",
                                fontSize = 18.sp,
                                modifier = Modifier.fillMaxWidth(),
                                textAlign = TextAlign.Center,
                                fontWeight = FontWeight.ExtraBold


                            )
                        }


                    }
                    //End of card
                           Spacer(modifier = Modifier.width(20.dp))
                }
                //End of Row





            }


            }
         //End of row1



        }
        //End of the main card

    }




@Composable
@Preview(showBackground = true)
fun DashboardScreenPreview(){
    DashboardScreen(rememberNavController())

}