package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var decrementButton: Button
    lateinit var incrementButton: Button
    lateinit var textView: TextView

    private var count: Count = Count.Base(2, 4, 0)
    private lateinit var state: UiState

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        decrementButton = findViewById(R.id.decrementButton)
        incrementButton = findViewById(R.id.incrementButton)
        textView = findViewById(R.id.countTextView)

        decrementButton.setOnClickListener{
            state = count.decrement(textView.text.toString())
            state.applay(incrementButton, decrementButton, textView)
        }

        incrementButton.setOnClickListener{
            state = count.increment(textView.text.toString())
            state.applay(incrementButton, decrementButton, textView)
        }

        if (savedInstanceState == null) {
            state = count.initial(textView.text.toString())
            state.applay(incrementButton, decrementButton, textView)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putSerializable(KEY, state)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        state = savedInstanceState.getSerializable(KEY) as UiState
        state.applay(incrementButton, decrementButton, textView)
    }

    companion object {
        private const val KEY:String = "STATE"
    }
}