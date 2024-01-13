package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.Firebase
import com.google.firebase.database.database

class Login: AppCompatActivity() {

    private lateinit var username: EditText
    private lateinit var logInBtn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.first_screen_login)

        username = findViewById(R.id.username)
        logInBtn = findViewById(R.id.loginBtn)

        logInBtn.setOnClickListener {
            val newUser = User(username.text.toString(),"def")
            val database = Firebase.database

            val myRef = database.getReference("Users")
            myRef.push().setValue(newUser).addOnSuccessListener {
                // Operacja zakończona sukcesem
                Toast.makeText(this@Login, "Dodano nowego użytkownika.", Toast.LENGTH_SHORT).show()
            }
                .addOnFailureListener {
                    // Wystąpił błąd podczas dodawania do bazy danych
                    Toast.makeText(this@Login, "Błąd podczas dodawania użytkownika: ${it.message}", Toast.LENGTH_SHORT).show()
                }

        }

    }
}