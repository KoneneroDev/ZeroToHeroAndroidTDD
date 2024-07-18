package ru.easycode.zerotoheroandroidtdd

import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import java.io.Serializable

interface UiState: Serializable {

    fun apply(textView: TextView, textInputEditText: TextInputEditText)

    class Base(private val text: String): UiState {

        override fun apply(textView: TextView, textInputEditText: TextInputEditText) {
            textView.text = text
            textInputEditText.setText("")
        }

    }

}