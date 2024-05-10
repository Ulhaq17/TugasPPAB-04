package com.l0122095.ulhaq.tugasppab_04

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var btnProfile : Button
    private lateinit var btnGithub : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        btnProfile = findViewById(R.id.btn1)
        btnProfile.setOnClickListener(this)
        btnGithub = findViewById(R.id.btn2)
        btnGithub.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.btn1 ->{
                val profileIntent = Intent(this@MainActivity, ProfileActivity::class.java)
                profileIntent.putExtra(ProfileActivity.EXTRA_NIM, "L0122095")
                profileIntent.putExtra(ProfileActivity.EXTRA_NAME, "Mochammad Dhiya Ulhaq")
                profileIntent.putExtra(ProfileActivity.EXTRA_BATCH, 2022)
                profileIntent.putExtra(ProfileActivity.EXTRA_MAJOR, "Informatics")
                profileIntent.putExtra(ProfileActivity.EXTRA_SELFDESCRIPTION, "I like to eat")
                startActivity(profileIntent)
            }

            R.id.btn2 ->{
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse("https://github.com/Ulhaq17")
                startActivity(intent)
            }
        }
    }
}