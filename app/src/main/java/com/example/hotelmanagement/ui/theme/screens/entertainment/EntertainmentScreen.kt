package com.example.hotelmanagement.ui.theme.screens.entertainment

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
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
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.hotelmanagement.R
import com.example.hotelmanagement.ui.theme.newPink
import com.example.hotelmanagement.ui.theme.screens.intent.bottomNavItems

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun EntertainmentScreen(navController: NavController){


    Column(modifier = Modifier.fillMaxSize()
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
                    title = { Text(text = "Pride Inn Hotel", color = Color.White) },
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

                    ) {



                    Row (modifier = Modifier.padding(start = 10.dp)){

                        Column {

                            Text(
                                text = "Pride Inn",
                                fontSize = 40.sp

                            )
                            Spacer(modifier = Modifier.width(40.dp))

                            Text(
                                text = "Entertainment",
                                fontSize = 40.sp,
                                fontFamily = FontFamily.SansSerif

                            )
                        }
                        Spacer(modifier = Modifier.width(40.dp))


                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(imageVector = Icons.Default.ThumbUp, contentDescription = "", modifier = Modifier.size(150.dp))
                        }



                    }
                    Spacer(modifier = Modifier.height(40.dp))

                    //code for searchbar
                    var search by remember { mutableStateOf("")   }

                    OutlinedTextField(
                        value = search,
                        onValueChange = {search=it},
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 20.dp, end = 20.dp),
                        leadingIcon = { Icon(imageVector = Icons.Default.Search, contentDescription = "")},
                        placeholder = { Text(text = "Search Entertainment") }

                    )


                    Spacer(modifier = Modifier.height(20.dp))


                    Box (modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 10.dp, end = 10.dp)
                        .height(280.dp), contentAlignment = Alignment.Center)
                    {
                        Image(
                            painter = painterResource(id = R.drawable.img_24),
                            contentDescription = "home",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop
                        )
                    }


                    Spacer(modifier = Modifier.height(20.dp))


                    Box (modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 10.dp, end = 10.dp)
                        .height(280.dp), contentAlignment = Alignment.Center)
                    {
                        Image(
                            painter = painterResource(id = R.drawable.img_25),
                            contentDescription = "home",
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop
                        )
                    }






                }
            }

        )



    }














}
@Composable
@Preview(showBackground = true)
fun EntertainmentScreenPreview(){
    EntertainmentScreen(rememberNavController())

}