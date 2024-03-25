package com.example.my

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private var job: Job? = null
    lateinit var button: Button
    lateinit var randomTextView: TextView
    lateinit var textView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupButton()
        setRandomValueBetweenOneToHundred()
        setJobAndLaunch()

    }

    private fun setJobAndLaunch() {
        job=lifecycleScope.launch {
            for (i in 1.. 100){
                if (isActive){
                    textView.text=i.toString()
                    delay(500)
                }
            }
        }
    }

    private fun setRandomValueBetweenOneToHundred() {
        val randomValue = List(10) { Random.nextInt(1, 100) }
        randomTextView.text = randomValue.toString()
    }

    private fun setupButton() {
        button.setOnClickListener{
            job?.cancel()
            checkAnswerAndShowToast()
        }
    }

    private fun checkAnswerAndShowToast() {
        val textView = textView.text.toString()
        val randomTextView = randomTextView.text.toString()
        if (textView == randomTextView){
            Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Wrong", Toast.LENGTH_SHORT).show()
        }

    }

}





