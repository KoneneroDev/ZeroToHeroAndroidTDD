package ru.easycode.zerotoheroandroidtdd

import android.widget.Button
import android.widget.TextView
import java.io.Serializable

interface UiState: Serializable {

    fun applay(text: TextView, button: Button)

    abstract class Abstract(private var text: String) : UiState {
        override fun applay(text: TextView, button: Button) {
            text.text = this.text
        }
    }

    data class Base(private var text : String) : Abstract(text)

    data class Max(private var text : String) : Abstract(text) {
        override fun applay(text: TextView, button: Button) {
            super.applay(text, button)
            button.isEnabled = false
        }
    }
}
