package com.example.hotelmanagement.data

import android.app.ProgressDialog
import android.content.Context
import android.net.Uri
import android.widget.Toast
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.navigation.NavController
import com.example.hotelmanagement.models.Room
import com.example.hotelmanagement.navigation.ADD_ROOM_URL

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.storage.FirebaseStorage

class RoomViewModel(var navController: NavController, var context: Context) {


    fun uploadRoom(name:String, price:String, phone: String,category: String,filePath: Uri){
        val productId = System.currentTimeMillis().toString()
        val storageRef = FirebaseStorage.getInstance().getReference()
            .child("Rooms/$productId")
        storageRef.putFile(filePath).addOnCompleteListener{
            if (it.isSuccessful){
                // Save data to db
                storageRef.downloadUrl.addOnSuccessListener {
                    var imageUrl = it.toString()
                    var product = Room(name,price,phone,category,imageUrl,productId)
                    var databaseRef = FirebaseDatabase.getInstance().getReference()
                        .child("Rooms/$productId")
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

    fun allRooms(
        product: MutableState<Room>,
        rooms: SnapshotStateList<Room>):SnapshotStateList<Room>{
        var ref = FirebaseDatabase.getInstance().getReference()
            .child("Rooms")
        ref.addValueEventListener(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                rooms.clear()
                for (snap in snapshot.children){
                    var retrievedProduct = snap.getValue(Room::class.java)
                    product.value = retrievedProduct!!
                    rooms.add(retrievedProduct)
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context, "DB locked", Toast.LENGTH_SHORT).show()
            }
        })
        return rooms
    }

    fun updateRoom(productId:String){
        var ref = FirebaseDatabase.getInstance().getReference()
            .child("Rooms/$productId")
        ref.removeValue()
        navController.navigate(ADD_ROOM_URL)
    }


    fun deleteRoom(productId:String){
        var ref = FirebaseDatabase.getInstance().getReference()
            .child("Rooms/$productId")
        ref.removeValue()
        Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show()
    }
}