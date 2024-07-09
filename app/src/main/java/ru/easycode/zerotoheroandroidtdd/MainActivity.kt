package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import java.io.Serializable

class MainActivity : AppCompatActivity() {
    private var state : State = State.Initial
    private lateinit var textView: TextView
    private lateinit var linearLayout: LinearLayout
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        linearLayout = findViewById(R.id.rootLayout)
        textView = findViewById(R.id.titleTextView)
        button = findViewById(R.id.removeButton)

        button.setOnClickListener{
            state = State.Remove
            state.applay(linearLayout, textView, button)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putSerializable("STATE", state)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        state = savedInstanceState.getSerializable("STATE") as State
        state.applay(linearLayout, textView, button)
    }

    interface State : Serializable {
        fun applay(linearLayout: LinearLayout, textView: TextView, button: Button)

        object Initial : State {
            override fun applay(linearLayout: LinearLayout, textView: TextView, button: Button) = Unit
        }

        object Remove : State {
            override fun applay(linearLayout: LinearLayout, textView: TextView, button: Button) {
                linearLayout.removeView(textView)
                button.isEnabled = false
            }
        }
    }
}