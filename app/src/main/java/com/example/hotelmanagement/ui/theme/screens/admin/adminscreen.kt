package com.example.hotelmanagement.ui.theme.screens.admin

import android.annotation.SuppressLint
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
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.hotelmanagement.R
import com.example.hotelmanagement.navigation.ADD_MENU_URL
import com.example.hotelmanagement.navigation.ADD_ROOM_URL
import com.example.hotelmanagement.navigation.VIEW_ACCOUNT
import com.example.hotelmanagement.ui.theme.newPink
import com.example.hotelmanagement.ui.theme.screens.intent.bottomNavItems

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun AdminScreen(navController: NavController){


    Column(modifier = androidx.compose.ui.Modifier.fillMaxSize()
    ) {


        var selected by remember { mutableIntStateOf(0) }
        Scaffold(
            bottomBar = {
                NavigationBar(
                    containerColor = newPink,
                ) {
                    bottomNavItems.forEachIndexed { index, bottomNavItem ->
                        NavigationBarItem(
                            selected = index == selected,
                            onClick = {
                                selected = index
                                navController.navigate(bottomNavItem.route)
                            },
                            icon = {
                                BadgedBox(
                                    badge = {
                                        if (bottomNavItem.badges != 0) {
                                            Badge {
                                                Text(text = bottomNavItem.badges.toString())
                                            }
                                        } else if (bottomNavItem.hasNews) {
                                            Badge()
                                        }
                                    }
                                ) {
                                    Icon(imageVector =
                                    if (index == selected)
                                        bottomNavItem.selectedIcon
                                    else
                                        bottomNavItem.unselectedIcon,
                                        contentDescription = bottomNavItem.title)
                                }

                            },
                            label = {
                                Text(text = bottomNavItem.title)
                            })
                    }
                }

            },
            topBar = {
                TopAppBar(
                    title = { Text(text = "Admin Section", color = Color.White) },
                    colors = TopAppBarDefaults.mediumTopAppBarColors(newPink)
                )

            },


            floatingActionButton = {
                FloatingActionButton(onClick = { /*TODO*/ }) {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(imageVector = Icons.Default.Add,
                            contentDescription = "menu")
                    }
                }
            },
            //Content Section
            content = @Composable {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 70.dp)
                        .verticalScroll(rememberScrollState()),
                    horizontalAlignment = Alignment.CenterHorizontally

                    ) {




                    Text(
                        text = "Choose what to upload!",
                        fontSize = 20.sp,
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.ExtraBold

                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    Card (modifier = Modifier
                        .clickable {
                            navController.navigate(ADD_ROOM_URL)
                        }
                        .fillMaxWidth().height(200.dp).padding(start = 10.dp, end = 10.dp)){
                        Box (modifier = Modifier
                            .fillMaxSize(),
                            contentAlignment = Alignment.Center)
                        {
                            Image(
                                painter = painterResource(id = R.drawable.img_26),
                                contentDescription = "home",
                                modifier = Modifier.fillMaxSize(),
                                contentScale = ContentScale.Crop
                            )

                            Text(
                                text = "Rooms",
                                fontSize = 35.sp,
                                fontFamily = FontFamily.SansSerif,
                                fontWeight = FontWeight.ExtraBold,
                                color = Color.White

                            )


                        }


                    }

                    Spacer(modifier = Modifier.height(10.dp))

                    Card (modifier = Modifier.fillMaxWidth().height(200.dp).padding(start = 10.dp, end = 10.dp)
                        .clickable {
                            navController.navigate(ADD_MENU_URL)
                        }){
                        Box (modifier = Modifier
                            .fillMaxSize(),
                            contentAlignment = Alignment.Center)
                        {
                            Image(
                                painter = painterResource(id = R.drawable.img_28),
                                contentDescription = "home",
                                modifier = Modifier.fillMaxSize(),
                                contentScale = ContentScale.Crop
                            )

                            Text(
                                text = "Menu",
                                fontSize = 35.sp,
                                fontFamily = FontFamily.SansSerif,
                                fontWeight = FontWeight.ExtraBold,
                                color = Color.White

                            )


                        }


                    }



                    Spacer(modifier = Modifier.height(10.dp))

                    Text(
                        text = "Check all room bookings done!",
                        fontSize = 20.sp,
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.ExtraBold

                    )
                    Spacer(modifier = Modifier.height(10.dp))


                    Card (modifier = Modifier
                        .clickable {
                            navController.navigate(VIEW_ACCOUNT)
                        }
                        .fillMaxWidth().height(200.dp).padding(start = 10.dp, end = 10.dp)){
                        Box (modifier = Modifier
                            .fillMaxSize(),
                            contentAlignment = Alignment.Center)
                        {
                            Image(
                                painter = painterResource(id = R.drawable.img_26),
                                contentDescription = "home",
                                modifier = Modifier.fillMaxSize(),
                                contentScale = ContentScale.Crop
                            )

                            Text(
                                text = "View Bookings",
                                fontSize = 35.sp,
                                fontFamily = FontFamily.SansSerif,
                                fontWeight = FontWeight.ExtraBold,
                                color = Color.White

                            )


                        }


                    }

                    Spacer(modifier = Modifier.height(10.dp))











                }
            }

        )



    }


}

val bottomNavItems = listOf(
    BottomNavItem(
        title = "Home",
        route="home",
        selectedIcon= Icons.Filled.Home,
        unselectedIcon= Icons.Outlined.Home,
        hasNews = false,
        badges=0
    ),


    )



data class BottomNavItem(
    val title :String,
    val route :String,
    val selectedIcon: ImageVector,
    val unselectedIcon : ImageVector,
    val hasNews :Boolean,
    val badges :Int
)

@Composable
@Preview(showBackground = true)
fun AdminScreenPreview(){
    AdminScreen(rememberNavController())

}