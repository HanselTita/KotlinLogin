package com.softhans.kotlinlogin

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_signup.*

class SignUpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)


        /**
         * I used sharedpreferences for both activities to store the username and password
         */
            val sharedPreferences = this.getSharedPreferences("com.softhans.kotlinlogin", Context.MODE_PRIVATE)

        //retriving current user's name and password.
            var name = userName.text
            var password = userPwd.text

        //saving current name and password as the required name and password using the save button
        btnSave.setOnClickListener {
            val storedName = sharedPreferences.getString("User", name.toString())
            val storedPwd = sharedPreferences.getString("Pwd", password.toString())

            Toast.makeText(this, "stored Name: $storedName" + "stored Pwd: $storedPwd", Toast.LENGTH_SHORT).show()

        //Carrying over the username and password over to the login activity
            intent = Intent(this, LoginActivity::class.java)
            intent.putExtra("user", storedName)
            intent.putExtra("password", storedPwd)
            startActivity(intent)
        }




    }
}
