package ru.easycode.zerotoheroandroidtdd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var linerLayout = LinearLayout(this)
        var textView = TextView(this)
        textView.id = R.id.titleTextView
        textView.text = "I am an Android Developer!"
        var buton = Button(this)
        linerLayout.addView(textView)
        linerLayout.addView(buton)
        setContentView(linerLayout)
    }
}