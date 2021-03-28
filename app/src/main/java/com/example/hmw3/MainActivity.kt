package com.example.hmw3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    var emailIsValid = true
    var passwordIsValid = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val email = findViewById<EditText>(R.id.email)
        val password = findViewById<EditText>(R.id.password)
        val button = findViewById<Button>(R.id.login_button)

        fun emailValidation( email:EditText) :Boolean {
            if(email.text.toString().isEmpty()) {
                emailIsValid = false
                email.error = "Invalid email"
            }
            else if(!((email.text.toString().contains("@gmail.com")) || (email.text.toString().contains("@mail.ru")))) {
                emailIsValid = false
                email.error = "Invalid email"
            }
            return emailIsValid
        }
        fun passwordValidation(password:EditText ) : Boolean {
            if(password.text.isEmpty()) {
                passwordIsValid = false
                password.error = "Invalid password"
            }
            else if(password.text.toString().length < 8) {
                passwordIsValid = false
                password.error = "Invalid password"
            }
            else if(password.text.toString() == "12345678" || password.text.toString() == "87654321" || password.text.toString() =="00000000") {
                passwordIsValid = false
                password.error = "Invalid password"
            }
            return passwordIsValid
        }
        fun check() {
            emailValidation(email)
            passwordValidation(password)
            if(emailIsValid && passwordIsValid) {
                Toast.makeText(applicationContext,"Successfully", Toast.LENGTH_SHORT).show()
            }
        }
        button.setOnClickListener {
            check()
            Toast.makeText(applicationContext,"${email.text}  mail is $emailIsValid",Toast.LENGTH_SHORT).show()
            Toast.makeText(applicationContext,"${password.text} password is $passwordIsValid",Toast.LENGTH_SHORT).show()
        }
    }
}