package com.example.firstai

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.ai.client.generativeai.GenerativeModel
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val eTprompt =findViewById<EditText>(R.id.eTprompt)
        val btnsubmit=findViewById< Button>(R.id.btnsubmit)
        val tvresult=findViewById<TextView>(R.id.tvresult)

        btnsubmit.setOnClickListener {
            val prompt=eTprompt.text.toString()
            val generativeModel = GenerativeModel(
                modelName = "gemini-1.5-flash",
                // Access your API key as a Build Configuration variable (see "Set up your API key" above)
                apiKey = "AIzaSyCqG9R4PcDdwZ2CwDTXaP8DA1PaQDXli5s"
            )
            runBlocking {
                val response = generativeModel.generateContent(prompt)
                tvresult.text = response.text
            }
        }

    }
}