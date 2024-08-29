package com.example.hotelmanagement.models

class Room {
    var name:String = ""
    var price:String = ""
    var category:String = ""
    var phone:String = ""
    var imageUrl:String = ""
    var id:String = ""

    constructor(name: String, price: String,phone: String,category: String, imageUrl: String, id: String) {
        this.name = name
        this.price = price
        this.phone = phone
        this.category = category
        this.imageUrl = imageUrl
        this.id = id
    }

    constructor()
}