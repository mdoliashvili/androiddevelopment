package com.example.myapplication1

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_activity)

        val receivedEmail: EditText = findViewById(R.id.ReceivedEmail)
        val receivedRecipientEmail: EditText = findViewById(R.id.ReceivedRecipientEmail)
        val receivedMessage: EditText = findViewById(R.id.ReceivedMessage)
        val clearButton : Button = findViewById(R.id.clearButton)

        val email  = intent.getStringExtra("Email")
        val recipientEmail = intent.getStringExtra("RecipientEmail")
        val message = intent.getStringExtra("Message")

        receivedEmail.setText("From: "+email)
        receivedRecipientEmail.setText("To: "+recipientEmail)
        receivedMessage.setText(message)

        clearButton.setOnClickListener {
            receivedEmail.setText("")
            receivedRecipientEmail.setText("")
            receivedMessage.setText("")
            Toast.makeText(this, "Fields Cleared!", Toast.LENGTH_SHORT).show()
        }
    }

}