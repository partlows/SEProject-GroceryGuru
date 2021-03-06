package com.example.groceryguruapp.db

object DbModels {

    class User(
        val userid: Long,
        val username: String,
        val userfirst: String,
        val userlast: String,
        val useremail: String,
        val userpassword: String,
        val isdeveloper: Boolean,
        val userlists: ByteArray?)

    class GroceryList(val listid: Int,
                       val list: ByteArray)

    class Items(val itemid: Int,
               val itemname: String,
               val itemcategory: String)
}