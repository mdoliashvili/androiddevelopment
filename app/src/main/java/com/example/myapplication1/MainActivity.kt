package com.example.myapplication1

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val email: EditText = findViewById(R.id.mainEmailInput)
        val recipientEmail : EditText = findViewById(R.id.mainRecipientEmail)
        val message : EditText = findViewById(R.id.mainMessage)
        val SendButton: Button = findViewById(R.id.sendButton)

        SendButton.setOnClickListener {
            val emailToSend = email.text.toString()
            val recipientToSend = recipientEmail.text.toString()
            val messageToSend = message.text.toString()


            val validationResult = validateInputs(emailToSend, recipientToSend, messageToSend)

            if (validationResult == null) {
                val intent = Intent(this, SecondActivity::class.java)
                intent.putExtra("Email", emailToSend)
                intent.putExtra("RecipientEmail", recipientToSend)
                intent.putExtra("Message", messageToSend)
                Toast.makeText(this, "Info Sent!", Toast.LENGTH_SHORT).show()
                startActivity(intent)
            } else {
                Toast.makeText(this, validationResult, Toast.LENGTH_SHORT).show()
            }
        }
    }
    private fun validateInputs(email: String, recipient: String, message: String): String? {

        if (email.isEmpty() || recipient.isEmpty() || message.isEmpty()) {
            return "All fields must not be empty."
        }

        if (!email.contains("@") || !recipient.contains("@")) {
            return "Both emails must contain the '@' symbol."
        }

        if (message.length > 250) {
            return "Message cannot exceed 250 characters."
        }
        return null
    }
}