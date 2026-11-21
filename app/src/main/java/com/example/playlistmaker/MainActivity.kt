package com.example.playlistmaker

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContentView(R.layout.activity_main)
        val view = findViewById<View>(R.id.main)

        ViewCompat.setOnApplyWindowInsetsListener(view) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())

            val initialLeft = view.paddingLeft
            val initialTop = view.paddingTop
            val initialRight = view.paddingRight
            val initialBottom = view.paddingBottom

            v.setPadding(
                initialLeft + systemBars.left,
                initialTop + systemBars.top,
                initialRight + systemBars.right,
                initialBottom + systemBars.bottom
            )
            insets
        }

        val searchButton = findViewById<Button>(R.id.search_button)
        val libraryButton = findViewById<Button>(R.id.library_button)
        val settingsButton = findViewById<Button>(R.id.settings_button)

        val stubSearchButtonClickListener: View.OnClickListener = object : View.OnClickListener{
            override fun onClick(p0: View?) {
                Toast.makeText(this@MainActivity, "Нажали на кнопку поиск", Toast.LENGTH_SHORT).show()
            }
        }

        searchButton.setOnClickListener(stubSearchButtonClickListener)

        libraryButton.setOnClickListener {
            Toast.makeText(this@MainActivity, "Нажали на кнопку медиатека", Toast.LENGTH_SHORT).show()
        }

        settingsButton.setOnClickListener {
            Toast.makeText(this@MainActivity, "Нажали на кнопку настройки", Toast.LENGTH_SHORT).show()
        }

    }
}