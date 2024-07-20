package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.TextView
import androidx.core.widget.addTextChangedListener
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.titleTextView)
        val button = findViewById<Button>(R.id.actionButton)
        val editTextVie = findViewById<TextInputEditText>(R.id.inputEditText)

        editTextVie.addTextChangedListener {
            button.isEnabled = editTextVie.text.toString().length >= 3
        }

        button.setOnClickListener {
            textView.text = editTextVie.text
            editTextVie.setText("")
        }
    }
}