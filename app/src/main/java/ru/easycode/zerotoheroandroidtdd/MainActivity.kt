package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = (application as App).model

        val textView = findViewById<TextView>(R.id.titleTextView)
        val button = findViewById<Button>(R.id.actionButton)
        val textInputEditText = findViewById<TextInputEditText>(R.id.inputEditText)

        button.setOnClickListener {
            viewModel.update(UiState.Base(textInputEditText.text.toString()))
        }

        viewModel.liveData().observe(this) {
            it.apply(textView, textInputEditText)
        }
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        viewModel.restore(BundleWrapper.Base(savedInstanceState))
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        viewModel.save(BundleWrapper.Base(outState))
    }
}