package com.kinopoisk.redirect

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val originalUri = intent?.data

        if (originalUri != null) {
            val originalUrl = originalUri.toString()
            // Заменяем домен на kinopoisk.cx
            val newUrl = originalUrl.replace("kinopoisk.ru", "kinopoisk.cx", ignoreCase = true)

            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(newUrl))
            startActivity(intent)
        }

        // Закрываем наше приложение после редиректа
        finish()
    }
}
