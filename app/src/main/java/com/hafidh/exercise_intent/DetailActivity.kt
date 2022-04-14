package com.hafidh.exercise_intent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hafidh.exercise_intent.MainActivity.Companion.EXTRA_PERSON
import com.hafidh.exercise_intent.data.Person
import com.hafidh.exercise_intent.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent = intent.getSerializableExtra(EXTRA_PERSON) as Person

        binding.tvName.text = intent.nama
        binding.tvAge.text = intent.umur.toString()
        binding.tvEmail.text = intent.email
        binding.tvDomicile.text = intent.domisili

        binding.tvStatus.text =
            if (intent.statusMenikah) "Menikah" else "Belum Menikah"
    }
}