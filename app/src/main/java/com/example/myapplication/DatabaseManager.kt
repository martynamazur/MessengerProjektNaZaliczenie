package com.example.myapplication

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class DatabaseManager private constructor() {

    private val database: FirebaseDatabase = FirebaseDatabase.getInstance()
    private val reference: DatabaseReference = database.getReference("Users")

    companion object{
        @Volatile
        private var INSTANCE: DatabaseManager? = null

        fun getInstance(): DatabaseManager =
            INSTANCE ?: synchronized(this){
                INSTANCE ?: DatabaseManager().also { INSTANCE = it }
            }
    }

    fun addUser(username: String, defaultValue: String) {
        val newUser = User(username, defaultValue)
        reference.push().setValue(newUser)
    }
}