package com.zybooks.pizzaparty

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.ceil

const val SLICES_PER_PIZZA = 8 //Int (number)

//MainActivity inherits the AppCompatActivity class inherits Activity class
class MainActivity : AppCompatActivity() {

    private lateinit var numAttendEditText: EditText //edittext for inputting number of people
    private lateinit var numPizzasTextView: TextView  //textview displaying number of pizzas- o/p

    //Activity method onCreate calls setContentView and findViewById methods
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        numAttendEditText = findViewById(R.id.num_attend_edit_text)
        numPizzasTextView = findViewById(R.id.num_pizzas_text_view)
    }

    //function calculate
    fun calculateClick(view: View) {
        val numAttendStr = numAttendEditText.text.toString()
        val numAttend = numAttendStr.toIntOrNull() ?: 0 // converting to int for calculation and returns result or null
        val slicesPerPerson = 4  //Int (number)
        val totalPizzas = ceil(numAttend * slicesPerPerson /
                SLICES_PER_PIZZA.toDouble()).toInt()
        numPizzasTextView.text = "Total pizzas: $totalPizzas"  //displaying o/p
    }
}