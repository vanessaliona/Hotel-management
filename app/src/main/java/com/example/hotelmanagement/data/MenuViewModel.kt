package com.example.hotelmanagement.data

import android.app.ProgressDialog
import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.navigation.NavController
import com.example.hotelmanagement.models.Menu
import com.example.hotelmanagement.navigation.ADD_MENU_URL
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.storage.FirebaseStorage

class MenuViewModel(var navController: NavController, var context: Context) {

    fun uploadMenu(name:String, quantity:String, price:String, phone: String,filePath: Uri){
        val productId = System.currentTimeMillis().toString()
        val storageRef = FirebaseStorage.getInstance().getReference()
            .child("Products/$productId")
        storageRef.putFile(filePath).addOnCompleteListener{
            if (it.isSuccessful){
                // Save data to db
                storageRef.downloadUrl.addOnSuccessListener {
                    var imageUrl = it.toString()
                    var product = Menu(name,quantity,price,phone,imageUrl,productId)
                    var databaseRef = FirebaseDatabase.getInstance().getReference()
                        .child("Menus/$productId")
                    databaseRef.setValue(product).addOnCompleteListener {
                        if (it.isSuccessful){
                            Toast.makeText(this.context, "Success", Toast.LENGTH_SHORT).show()
                        }else{
                            Toast.makeText(this.context, "Error", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }else{
                Toast.makeText(this.context, "Upload error", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun allMenu(
        menu: MutableState<Menu>,
        menus: SnapshotStateList<Menu>):SnapshotStateList<Menu>{
        var ref = FirebaseDatabase.getInstance().getReference()
            .child("Menus")
        ref.addValueEventListener(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                menus.clear()
                for (snap in snapshot.children){
                    var retrievedProduct = snap.getValue(Menu::class.java)
                    menu.value = retrievedProduct!!
                    menus.add(retrievedProduct)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context, "DB locked", Toast.LENGTH_SHORT).show()
            }
        })
        return menus
    }

    fun updateMenu(productId:String){
        var ref = FirebaseDatabase.getInstance().getReference()
            .child("Menus/$productId")
        ref.removeValue()
        navController.navigate(ADD_MENU_URL)
    }


    fun deleteMenu(productId:String){
        var ref = FirebaseDatabase.getInstance().getReference()
            .child("Menus/$productId")
        ref.removeValue()
        Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show()
    }
}