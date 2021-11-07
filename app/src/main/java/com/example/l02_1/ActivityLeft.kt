package com.example.l02_1

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class ActivityLeft : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_left)
        val buttonPhone = findViewById<Button>(R.id.button_phone)
        val buttonBrowser = findViewById<Button>(R.id.button_browser)
        buttonPhone.setOnClickListener(buttonsListener)
        buttonBrowser.setOnClickListener(buttonsListener)
    }

    fun runDial(phoneNum: String) {
        val intent = Intent(Intent.ACTION_DIAL).apply {
            data = Uri.parse("tel:$phoneNum")
        }
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }

    fun runBrowser(url: String) {
        val webpage: Uri = Uri.parse(url)
        val intent = Intent(Intent.ACTION_VIEW, webpage)
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }

    val buttonsListener = View.OnClickListener { v ->
        when(v.getId()) {
            R.id.button_phone -> {
                val textPhone = findViewById<EditText>(R.id.editText_phone)
                val phoneNum = textPhone.text.toString()
                runDial(phoneNum)
            }
            R.id.button_browser -> {
                val textBrowser = findViewById<EditText>(R.id.editText_browser)
                val website = textBrowser.text.toString()
                runBrowser(website)
            }
        }
    }
}