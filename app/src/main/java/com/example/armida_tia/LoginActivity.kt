package com.example.armida_tia

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.armida_tia.databinding.ActivityLoginBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar


class LoginActivity : AppCompatActivity() {
    private lateinit var  binding: ActivityLoginBinding // untuk definisikan activity login ke dalam binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityLoginBinding.inflate(layoutInflater) //untuk mengambil alih semua yang ad di dlm activity login
        setContentView(binding.root) // untuk menampilkannya

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
//        val btnLogin : Button = findViewById(R.id.btnlogin)
//        val email : EditText = findViewById(R.id.edtemail)
//        val password : EditText = findViewById(R.id.edtpassword)

        binding.btnLogin.setOnClickListener {
            val user = binding.edtemail.text.toString()
            val pass = binding.edtpassword.text.toString()

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            Toast.makeText(this, "Kembali ke halaman Login", Toast.LENGTH_SHORT).show()
        }

    }
}