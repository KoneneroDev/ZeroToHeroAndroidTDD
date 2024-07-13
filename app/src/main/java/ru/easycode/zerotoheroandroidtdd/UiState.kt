package ru.easycode.zerotoheroandroidtdd

import android.widget.Button
import android.widget.TextView
import java.io.Serializable

interface UiState: Serializable {

    fun applay(incrementButton: Button, decrementButton: Button, textView: TextView)

    data class Min(var text: String) : UiState {

        override fun applay(incrementButton: Button, decrementButton: Button, textView: TextView) {
            decrementButton.isEnabled = false
            incrementButton.isEnabled = true
            textView.text = text
        }

    }

    data class Base(var text: String) : UiState {
        override fun applay(incrementButton: Button, decrementButton: Button, textView: TextView) {
            textView.text = text
            decrementButton.isEnabled = true
            incrementButton.isEnabled = true
        }

    }

    data class Max(var text: String) : UiState {
        override fun applay(incrementButton: Button, decrementButton: Button, textView: TextView) {
            incrementButton.isEnabled = false
            decrementButton.isEnabled = true
            textView.text = text
        }

    }
}