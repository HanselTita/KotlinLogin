package com.softhans.kotlinlogin

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val sharedPreferences = this.getSharedPreferences("com.softhans.kotlinlogin", Context.MODE_PRIVATE)

        //Brought forward name and password from SignUp Activity
        val bundle : Bundle? = intent.extras
        val ownerName = bundle!!.get("user")
        val ownerPwd = bundle!!.get("password")

        //retriving current user's name and password.
        val name = userName.text
        val pwd = userPwd.text

        btnLogin.setOnClickListener {

            //storing current name and password
            val storedName = sharedPreferences.getString("User", name.toString())
            val storedPwd = sharedPreferences.getString("Pwd", pwd.toString())


            // Comparing current name and password with the brought forward name and password from Sign Up activity
            if(storedName == ownerName && storedPwd == ownerPwd){
                Toast.makeText(this, "welcome $ownerName" , Toast.LENGTH_SHORT).show()
            }
            else if (storedName ==ownerName && storedPwd != ownerPwd)
            {
                Toast.makeText(this, "incorrect password" , Toast.LENGTH_SHORT).show()
            }
            else if (storedName !=ownerName && storedPwd == ownerPwd)
            {
                Toast.makeText(this, "incorrect username" , Toast.LENGTH_SHORT).show()
            }
            else
            {
                Toast.makeText(this, "welcome customer" , Toast.LENGTH_SHORT).show()

            }
        }

    }
}
