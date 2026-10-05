package com.example.armida_tia

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.armida_tia.Pertemuan5.LimaActivity
import com.example.armida_tia.databinding.ActivityLoginBinding
import com.example.armida_tia.databinding.ActivityMainBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var  binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater) //untuk mengambil alih semua yang ad di dlm activity login
        setContentView(binding.root) // untuk menampilkannya

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val user = intent.getStringExtra("Email")
        val pass = intent.getStringExtra("Password")

        binding.txtemail.text = user
        binding.txtpass.setText(pass)

        binding.btnsnackbar.setOnClickListener {
            Snackbar.make(binding.root, "Halo ini snackbar", Snackbar.LENGTH_LONG)
                .setAction("kembali"){
                    //kembali
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    Toast.makeText(this, "Kembali ke main", Toast.LENGTH_SHORT).show()
                }
                .show()
        }
        binding.btnalert.setOnClickListener {

            MaterialAlertDialogBuilder(this)
                .setTitle("Hapus data")
                .setMessage("Data yang dihapus tidak " +
                        "bisa dikembalikan.")
                .setNegativeButton("Batal", null)
                .setPositiveButton("Hapus") { dialog, _ ->
                    // proses hapus
                    dialog.dismiss()
                }
                .setCancelable(false)
                .show()
        }
        binding.btnToLima.setOnClickListener {
            startActivity(Intent(this, LimaActivity::class.java))
        }
    }
}