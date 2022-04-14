package com.hafidh.exercise_intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hafidh.exercise_intent.data.Person
import com.hafidh.exercise_intent.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        submit()
    }

    // submit data to next activity
    private fun submit() {
        binding.btnSubmit.setOnClickListener {
            val name = binding.etName.text.toString()
            val age = binding.etUmur.text.toString().toInt()
            val email = binding.etEmail.text.toString()
            val domisili = binding.etDomisili.text.toString()
            // get value radio group
            val status = when (binding.rgStatus.checkedRadioButtonId) {
                binding.menikah.id -> true
                binding.belumMenikah.id -> false
                else -> false
            }
            validation(name, age, email, domisili, status)
        }
    }


    private fun validation(name: String, age: Int, email: String, domisili: String, status: Boolean): Boolean {
        if (name.isEmpty()) {
            binding.etName.error = "Nama tidak boleh kosong"
            return false
        }
        if (age < 18) {
            binding.etUmur.error = "Umur minimal 18 tahun"
            return false
        }
        if (email.isEmpty()) {
            binding.etEmail.error = "Email tidak boleh kosong"
            return false
        }
        if (domisili.isEmpty()) {
            binding.etDomisili.error = "Domisili tidak boleh kosong"
            return false
        }
        // if all validation success
        val intent = Intent(this, DetailActivity::class.java)
        val person = Person(name, age, email, domisili, status)
        intent.putExtra(EXTRA_PERSON, person)
        startActivity(intent)
        return true
    }

    companion object {
        const val EXTRA_PERSON = "extra_person"
    }

}