package com.example.wordchecker

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.pow

class MainActivity : AppCompatActivity() {

    lateinit var btn1: Button
    lateinit var edit1: EditText
    lateinit var view1: TextView
    lateinit var btn2: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn1 = findViewById(R.id.button)
        edit1 = findViewById(R.id.editText)
        view1 = findViewById(R.id.textView)
        btn2 = findViewById(R.id.button2)
        edit1.addTextChangedListener(textWatcher)

        btn1.setOnClickListener() {
            val reverseCheck: String = edit1.text.reversed().toString()
            if(edit1.text.toString() == reverseCheck){
                view1.text = "IT IS A PALINDROME NUMBER"
            } else {
                view1.text = "IT IS NOT A PALINDROME NUMBER"
            }
        }

       btn2.setOnClickListener() {

           val decimalChecker = edit1.text.toString().indexOf(".")
           val totalInputString = edit1.text.toString().length
           val totalIntChecker = (totalInputString.toString().toInt() - 1)
           val exponent = (totalIntChecker - decimalChecker).toString()
           val base = 10
           val result = (base.toFloat().pow(exponent.toFloat()))

           val initialValue = (edit1.text.toString().toFloat() * result)
           val finalValue = (edit1.text.toString().toFloat().toInt() * result)

           if(initialValue != finalValue) {
               view1.text = "IT IS NOT AN INTEGER"
           } else {
               view1.text = "IT IS AN INTEGER"
           }
       }
    }
    private var textWatcher: TextWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
            val string = edit1.text.toString()
            btn1.isEnabled = string.isNotEmpty()
            btn2.isEnabled = string.isNotEmpty()
        }
        override fun afterTextChanged(s: Editable) {}
    }
}
