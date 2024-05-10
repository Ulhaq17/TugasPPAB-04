package com.l0122095.ulhaq.tugasppab_04

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ProfileActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var btnShare : Button

    companion object{
        const val EXTRA_NIM = "extra_nim"
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_BATCH = "extra_batch"
        const val EXTRA_MAJOR = "extra_major"
        const val EXTRA_SELFDESCRIPTION = "extra_selfdescription"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_profile)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val nimProfileData : TextView = findViewById(R.id.nim)
        val nameProfileData : TextView = findViewById(R.id.name)
        val batchmajorProfileData : TextView = findViewById(R.id.batchmajor)
        val selfdescProfileData : TextView = findViewById(R.id.selfdesc)


        val nim = intent.getStringExtra(EXTRA_NIM)
        val name = intent.getStringExtra(EXTRA_NAME)
        val batch = intent.getIntExtra(EXTRA_BATCH, 0)
        val major = intent.getStringExtra(EXTRA_MAJOR)
        val selfdesc = intent.getStringExtra(EXTRA_SELFDESCRIPTION)


        val displayNim = "$nim"
        val displayName = "$name"
        val displayBatchMajor = "$major, $batch"
        val displaySelfdesc = "$selfdesc"

        nimProfileData.text = displayNim
        nameProfileData.text = displayName
        batchmajorProfileData.text = displayBatchMajor
        selfdescProfileData.text = displaySelfdesc

        btnShare = findViewById(R.id.btn3)
        btnShare.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.btn3 ->{
                val nim = intent.getStringExtra(EXTRA_NIM)
                val name = intent.getStringExtra(EXTRA_NAME)
                val intent = Intent(Intent.ACTION_SEND)
                intent.type = "text/plain"

                val message = "Name: $name\nNIM: $nim"

                intent.putExtra(Intent.EXTRA_TEXT, message)

                val chooser = Intent.createChooser(intent, "Pilih Aplikasi")
                startActivity(chooser)
            }
        }
    }
}