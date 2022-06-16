package thesopt.assignment.hot_yongmin.presentation.ui.auth

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import thesopt.assignment.hot_yongmin.data.local.database.GithubSharedPreferences
import thesopt.assignment.hot_yongmin.databinding.ActivitySettingBinding

class SettingActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySettingBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingBinding.inflate(layoutInflater)
        setContentView(binding.root)
        clickLogout()
        clickback()
    }

    private fun clickLogout() {
        binding.tvLogout.setOnClickListener {
            GithubSharedPreferences.setLogout()
            val intent = Intent(this, SignInActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
        }
    }

    private fun clickback(){
        binding.ivBack.setOnClickListener{
            finish()
        }
    }
}