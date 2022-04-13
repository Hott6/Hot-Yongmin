package thesopt.assignment.hot_yongmin.presentation.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import thesopt.assignment.hot_yongmin.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding : ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val intent = Intent(this, MainActivity::class.java)
        binding.ivProfile.setOnClickListener{
            startActivity(intent)
        }
    }
}