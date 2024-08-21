package com.example.hotelmanagement.ui.theme.screens.signup

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.hotelmanagement.R
import com.example.hotelmanagement.data.AuthViewModel
import com.example.hotelmanagement.navigation.ROUT_LOGIN
import com.example.hotelmanagement.ui.theme.Pink
import kotlin.reflect.KProperty

private operator fun Any.getValue(nothing: Nothing?, property: KProperty<*>): Any {
    TODO("Not yet implemented")
}

fun OutlinedTextField(value: String, onValueChange: () -> Unit, label: () -> Unit, modifier: Modifier, leadingIcon: () -> Unit, any: Any?) {

}

@SuppressLint("RememberReturnType")
@Composable
fun SignupScreen(navController: NavController){

Column(
    modifier = Modifier
        .fillMaxSize()
        .paint(painterResource(id = R.drawable.img_4), contentScale = ContentScale.FillBounds),

    horizontalAlignment = Alignment.CenterHorizontally) {
    Spacer(modifier = Modifier.height(40.dp))

    Image(
        painter = painterResource(id = R.drawable.img_4),
        contentDescription = "home",
        modifier = Modifier
            .size(200.dp),
        contentScale = ContentScale.Crop
    )

    Spacer(modifier = Modifier.height(40.dp))

    Text(
        text = "Hotel Management",
        fontSize = 40.sp,
        fontFamily = FontFamily.Default,
        color = Color.Blue

    )
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confpassword by remember { mutableStateOf("") }


    OutlinedTextField(
        value = name,
        onValueChange = { name = it },
        label = { Text(text = "Fullname :") },
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp),
        leadingIcon = { Icon(imageVector = Icons.Default.Person, contentDescription = "person") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)

    )
    Spacer(modifier = Modifier.height(40.dp))

    OutlinedTextField(
        value = email,
        onValueChange = { email = it },
        label = { Text(text = "Email Address :") },
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp),
        leadingIcon = { Icon(imageVector = Icons.Default.Person, contentDescription = "person") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
    )
    Spacer(modifier = Modifier.height(40.dp))

    OutlinedTextField(
        value = password,
        onValueChange = { password = it },
        label = { Text(text = "Password :") },
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp),
        leadingIcon = { Icon(imageVector = Icons.Default.Person, contentDescription = "person") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        visualTransformation = PasswordVisualTransformation()

    )
    Spacer(modifier = Modifier.height(40.dp))


    OutlinedTextField(
        value = confpassword,
        onValueChange = { confpassword = it },
        label = { Text(text = "Confirm password :") },
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp),
        leadingIcon = { Icon(imageVector = Icons.Default.Person, contentDescription = "person") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        visualTransformation = PasswordVisualTransformation()


    )
    val context = LocalContext.current
    val authViewModel = AuthViewModel.AuthViewModel(navController, context)
    Spacer(modifier = Modifier.height(40.dp))

    Button(
        onClick = {
            navController.navigate(ROUT_LOGIN)
        },
        modifier = Modifier
            .fillMaxWidth()
            .height(50.dp)
            .padding(start = 20.dp, end = 20.dp),
        colors = ButtonDefaults.buttonColors(Pink),
        shape = RoundedCornerShape(10.dp)
    ) {
        Text(text = "CREATE ACCOUNT")

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = { authViewModel.login(email, password) },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .padding(start = 20.dp, end = 20.dp),
            colors = ButtonDefaults.buttonColors(Pink),
            shape = RoundedCornerShape(10.dp)
        ) {
            Text(text = "LOGIN")
        }
        Spacer(modifier = Modifier.height(40.dp))



    }
}


}

@Composable
@Preview(showBackground = true)
fun SignupScreenPreview(){
    SignupScreen(rememberNavController())
}






