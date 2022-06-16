package thesopt.assignment.hot_yongmin.presentation.ui.onboarding

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import thesopt.assignment.hot_yongmin.R
import thesopt.assignment.hot_yongmin.data.local.database.GithubSharedPreferences
import thesopt.assignment.hot_yongmin.databinding.ActivitySplashBinding
import thesopt.assignment.hot_yongmin.presentation.ui.auth.SignInActivity
import thesopt.assignment.hot_yongmin.presentation.ui.main.MainActivity

class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        GithubSharedPreferences.init(this)
        setImageSize()
        setDelay()
        setContentView(binding.root)
    }

    private fun setImageSize() {
        val display = this.resources.displayMetrics
        val deviceWidth = display.widthPixels
        val ratio: Double = 100 / 360.0
        val imagePadding: Int = (ratio * deviceWidth).toInt()
        binding.imageView.setPadding(imagePadding, 0, imagePadding, 0)
    }

    private fun checkOnboarding() {
        if(GithubSharedPreferences.onBoarding){
        //if (GithubSharedPreferences.getOnboarding()) {
            checkAutoLogin()
        } else {
            val intent = Intent(this, OnboardingActivity::class.java)
            startActivity(intent)
        }
    }

    private fun checkAutoLogin() {
        if(GithubSharedPreferences.autoLogin){
        //if (GithubSharedPreferences.getAutoLogin()) {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        } else {
            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setDelay() {
        Handler(Looper.getMainLooper()).postDelayed({
            val fadeAnim: Animation = AnimationUtils.loadAnimation(this, R.anim.splash_animation)
            binding.imageView.startAnimation(fadeAnim)
            checkOnboarding()
            finish()
        }, 1500L)
    }
}