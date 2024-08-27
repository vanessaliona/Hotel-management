package com.example.propertyplus.ui.theme.screens.dashboard

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.hotelmanagement.R
import com.example.hotelmanagement.navigation.ROUT_DRINK
import com.example.hotelmanagement.navigation.ROUT_ENTERTAINMENT
import com.example.hotelmanagement.navigation.ROUT_FOOD
import com.example.hotelmanagement.navigation.ROUT_HOTEL
import com.example.hotelmanagement.navigation.ROUT_INTENT
import com.example.hotelmanagement.navigation.ROUT_MENU
import com.example.hotelmanagement.navigation.ROUT_ROOM
import com.example.hotelmanagement.ui.theme.Pink

@Composable
fun DashboardScreen(navController: NavController) {

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {

        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = "Pride Inn",
            fontSize = 40.sp,
            fontFamily = FontFamily.SansSerif,
            color = Color.Magenta
        )
        Spacer(modifier = Modifier.height(30.dp))
        Image(
            painter = painterResource(id = R.drawable.img_6),
            contentDescription = "Home",
            modifier = Modifier
                .size(100.dp),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = "We are delighted to have you with us",
            fontSize = 18.sp,
            fontFamily = FontFamily.Default

        )
        Spacer(modifier = Modifier.height(5.dp))
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
                        .height(180.dp)
                        .clickable { navController.navigate(ROUT_HOTEL) }) {
                        Column {
                            Spacer(modifier = Modifier.height(15.dp))

                            Box(
                                modifier = Modifier.fillMaxWidth(),
                                contentAlignment = Alignment.Center
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.img_13),
                                    contentDescription = "Home",
                                    modifier = Modifier.size(100.dp)
                                )
                            }
                            Spacer(modifier = Modifier.height(15.dp))

                            Text(
                                text = "Hotels",
                                fontSize = 18.sp,
                                modifier = Modifier.fillMaxWidth(),
                                textAlign = TextAlign.Center

                            )
                        }


                    }
                    //End of card

                    Spacer(modifier = Modifier.width(20.dp))

                    //Card
                    Card(modifier = Modifier
                        .width(160.dp)
                        .height(180.dp)
                        .clickable { navController.navigate(ROUT_MENU) }
                    ) {
                        Column {
                            Spacer(modifier = Modifier.height(20.dp))

                            Box(
                                modifier = Modifier.fillMaxWidth(),
                                contentAlignment = Alignment.Center
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.img_12),
                                    contentDescription = "Hotel",
                                    modifier = Modifier.size(100.dp)
                                )
                            }
                            Spacer(modifier = Modifier.height(15.dp))

                            Text(
                             text = "Menu",
                                fontSize = 18.sp,
                                modifier = Modifier.fillMaxWidth(),
                                textAlign = TextAlign.Center,



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
                        .height(180.dp)
                        .clickable { navController.navigate(ROUT_ENTERTAINMENT) }) {
                        Column {
                            Spacer(modifier = Modifier.height(15.dp))

                            Box(
                                modifier = Modifier.fillMaxWidth(),
                                contentAlignment = Alignment.Center
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.img_1),
                                    contentDescription = "Entertainment",
                                    modifier = Modifier.size(100.dp)
                                )
                            }
                            Spacer(modifier = Modifier.height(15.dp))

                            Text(
                                text = "Entertainment",
                                fontSize = 18.sp,
                                modifier = Modifier.fillMaxWidth(),
                                textAlign = TextAlign.Center

                            )
                        }


                    }
                    //End of card

                        Spacer(modifier = Modifier.width(20.dp))

                    //Card
                    Card(modifier = Modifier
                        .width(160.dp)
                        .height(180.dp)
                        .clickable { navController.navigate(ROUT_ROOM ) }) {
                        Column {
                            Spacer(modifier = Modifier.height(20.dp))

                            Box(
                                modifier = Modifier.fillMaxWidth(),
                                contentAlignment = Alignment.Center
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.img_8),
                                    contentDescription = "Rooms",
                                    modifier = Modifier.size(100.dp)
                                )
                            }
                            Spacer(modifier = Modifier.height(15.dp))

                            Text(
                                text = "Rooms",
                                fontSize = 18.sp,
                                modifier = Modifier.fillMaxWidth(),
                                textAlign = TextAlign.Center

                            )
                        }


                    }
                    //End of card
                           Spacer(modifier = Modifier.width(20.dp))
                }
                //End of Row
                //Row1
                Row(modifier = Modifier.padding(20.dp)) {
                    //Card
                    Card(modifier = Modifier
                        .width(160.dp)
                        .height(180.dp)
                        .clickable { navController.navigate(ROUT_DRINK) }) {
                        Column {
                            Spacer(modifier = Modifier.height(15.dp))

                            Box(
                                modifier = Modifier.fillMaxWidth(),
                                contentAlignment = Alignment.Center
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.img_10),
                                    contentDescription = "Drinks",
                                    modifier = Modifier.size(100.dp)
                                )
                            }
                            Spacer(modifier = Modifier.height(15.dp))

                            Text(
                                text = "Drinks",
                                fontSize = 18.sp,
                                modifier = Modifier.fillMaxWidth(),
                                textAlign = TextAlign.Center

                            )
                        }


                    }
                    //End of card

                             Spacer(modifier = Modifier.width(20.dp))

                    //Card
                    Card(modifier = Modifier
                        .width(160.dp)
                        .height(180.dp)
                        .clickable { navController.navigate(ROUT_FOOD) }) {
                        Column {
                            Spacer(modifier = Modifier.height(20.dp))

                            Box(
                                modifier = Modifier.fillMaxWidth(),
                                contentAlignment = Alignment.Center
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.img_9),
                                    contentDescription = "Food",
                                    modifier = Modifier.size(100.dp)
                                )
                            }
                            Spacer(modifier = Modifier.height(15.dp))

                            Text(
                                text = "Food",
                                fontSize = 18.sp,
                                modifier = Modifier.fillMaxWidth(),
                                textAlign = TextAlign.Center

                            )
                        }


                    }
                    //End of card

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