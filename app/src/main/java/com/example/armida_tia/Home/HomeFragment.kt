package com.example.armida_tia.Home

import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.armida_tia.Home.Pertemuan5.LimaActivity
import com.example.armida_tia.Home.Pertemuan6.EnamActivity
import com.example.armida_tia.LoginActivity
import com.example.armida_tia.MainActivity
import com.example.armida_tia.databinding.FragmentHomeBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        (requireActivity() as AppCompatActivity).setSupportActionBar(binding.toolbar)
        (requireActivity() as AppCompatActivity).supportActionBar?.title = "Home"
        super.onViewCreated(view, savedInstanceState)
        val sharedPref = requireContext().getSharedPreferences("user_pref", MODE_PRIVATE)
        val user = requireActivity().intent.getStringExtra("Email")
        val pass = requireActivity().intent.getStringExtra("Password")


        binding.btnsnackbar.setOnClickListener {
            Snackbar.make(binding.root, "Halo ini snackbar", Snackbar.LENGTH_LONG)
                .setAction("kembali") {
                    //kembali
                    val intent = Intent(requireContext(), MainActivity::class.java)
                    startActivity(intent)
                    Toast.makeText(requireContext(), "Kembali ke main", Toast.LENGTH_SHORT).show()
                }
                .show()
        }
        binding.btnalert.setOnClickListener {

            MaterialAlertDialogBuilder(requireContext())
                .setTitle("Hapus data")
                .setMessage(
                    "Data yang dihapus tidak " +
                            "bisa dikembalikan."
                )
                .setNegativeButton("Batal", null)
                .setPositiveButton("Hapus") { dialog, _ ->
                    // proses hapus
                    dialog.dismiss()
                }
                .setCancelable(false)
                .show()
        }
        binding.btnLogout.setOnClickListener {
            AlertDialog.Builder(requireContext())
                .setTitle("Logout")
                .setMessage("Apakah Anda yakin ingin keluar?")
                .setPositiveButton("Ya") { dialog, _ ->
                    val editor = sharedPref.edit()
                    editor.clear()
                    editor.apply()
                    dialog.dismiss()
                    startActivity(Intent(requireContext(), LoginActivity::class.java))
                    requireActivity().finish()
                }
                .setNegativeButton("Batal") { dialog, _ -> dialog.dismiss() }
                .show()
        }
        binding.btnToLima.setOnClickListener {
            startActivity(Intent(requireContext(), LimaActivity::class.java))
        }
        binding.btnToEnam.setOnClickListener {
            startActivity(Intent(requireContext(), EnamActivity::class.java))
        }
    }
}
