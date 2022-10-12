package com.example.revchallengechap4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.revchallengechap4.databinding.ActivityMainBinding
import com.example.revchallengechap4.databinding.ActivityRegisterBinding
import com.example.revchallengechap4.helper.Constant
import com.example.revchallengechap4.helper.PrefHelper
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity() {
    lateinit var binding : ActivityRegisterBinding
    lateinit var prefHelper: PrefHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        prefHelper = PrefHelper(this)

        buttonRegister.setOnClickListener {
            if (editUsername.text.isNotEmpty() && editEmail.text.isNotEmpty() && editPassword.text.isNotEmpty() && editConformPassword.text.isNotEmpty() ) {
                saveSession( editUsername.text.toString(), editEmail.text.toString(), editPassword.text.toString(), editConformPassword.text.toString() )
                showMessage( "Berhasil register" )
                moveIntent()
            }
        }
    }
    private fun saveSession(username: String, email: String, password: String, conformpassword: String){
        prefHelper.put( Constant.PREF_USERNAME, username )
        prefHelper.put( Constant.PREF_EMAIL, email )
        prefHelper.put( Constant.PREF_PASSWORD, password )
        prefHelper.put( Constant.PREF_CONFORM_PASSWORD, conformpassword )
        prefHelper.put( Constant.PREF_IS_REGISTER, true)
    }

    private fun moveIntent(){
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    private fun showMessage(message: String) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    }

}