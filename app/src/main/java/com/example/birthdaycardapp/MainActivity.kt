package com.example.birthdaycardapp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSave.setOnClickListener {
            val firstName = etFirstName.text.toString()
            val lastName = etLastName.text.toString()
            val birthDate = etBirthDate.text.toString()
            val phoneNumber = etPhoneNumber.text.toString()

            // Передача данных на второй экран
            val intent = Intent(this, DetailActivity::class.java).apply {
                putExtra("FIRST_NAME", firstName)
                putExtra("LAST_NAME", lastName)
                putExtra("BIRTH_DATE", birthDate)
                putExtra("PHONE_NUMBER", phoneNumber)
                // Здесь можно добавить передачу фото, если оно выбрано
            }
            startActivity(intent)
        }
    }
}