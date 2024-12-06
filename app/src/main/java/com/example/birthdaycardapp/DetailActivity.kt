package com.example.birthdaycardapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detail.*
import java.text.SimpleDateFormat
import java.util.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val firstName = intent.getStringExtra("FIRST_NAME")
        val lastName = intent.getStringExtra("LAST_NAME")
        val birthDate = intent.getStringExtra("BIRTH_DATE")
        val phoneNumber = intent.getStringExtra("PHONE_NUMBER")

        tvFirstName.text = "Имя: $firstName"
        tvLastName.text = "Фамилия: $lastName"
        tvPhoneNumber.text = "Телефон: $phoneNumber"

        birthDate?.let {
            val sdf = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault())
            val birthDateObj = sdf.parse(it)
            val currentDate = Calendar.getInstance()

            if (birthDateObj != null) {
                val age = currentDate.get(Calendar.YEAR) - birthDateObj.year - 1900
                tvAgeAndBirthdayInfo.text = "Возраст: $age лет."
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_exit, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_exit -> {
                finishAffinity()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}