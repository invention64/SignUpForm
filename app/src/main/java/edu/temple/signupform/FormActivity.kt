package edu.temple.signupform

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class FormActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.buttonSave).setOnClickListener{v -> validateFields()}
    }
    fun validateFields() : Boolean {
        var nameText = findViewById<EditText>(R.id.TextName)
        var emailText = findViewById<EditText>(R.id.TextEmail)
        var passwordText = findViewById<EditText>(R.id.TextPassword)
        var confirmText = findViewById<EditText>(R.id.TextConfirmPassword)
        if (nameText.text.isNullOrBlank()){
            nameText.error = "Name must not be Empty"
            return false
        }
        if (emailText.text.isNullOrBlank()){
            emailText.error = "Email must not be empty"
            return false
        }
        if (passwordText.text.isNullOrBlank()){
            passwordText.error = "Password must not be empty"
            return false
        }
        if (confirmText.text.equals(passwordText.text)){
            confirmText.error = "Passwords must match"
            return false
        }

        Toast.makeText(applicationContext, "Welcome, ${nameText.text}, to the SignUpFormApp", Toast.LENGTH_SHORT).show()
        return true
    }
}


