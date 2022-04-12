package thesopt.assignment.hot_yongmin.presentation.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import thesopt.assignment.hot_yongmin.R
import thesopt.assignment.hot_yongmin.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding : ActivityHomeBinding
    private var position = FOLLOWER_FRAGMENT

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initTransactionEvent()
    }

    private fun initTransactionEvent(){
        val followerFragment = FollowerFragment()
        val repoFragment = RepoFragment()

        binding.btnFollowerList.setOnClickListener{
            val transaction = supportFragmentManager.beginTransaction()
            if(position== REPO_FRAGMENT){
                transaction.replace(R.id.fcv_list, followerFragment).commit()
                position = FOLLOWER_FRAGMENT
            }
        }
        binding.btnRepoList.setOnClickListener{
            val transaction = supportFragmentManager.beginTransaction()
            if(position== FOLLOWER_FRAGMENT){
                transaction.replace(R.id.fcv_list, repoFragment).commit()
                position = REPO_FRAGMENT
            }
        }
    }

    companion object{
        const val FOLLOWER_FRAGMENT = 1
        const val REPO_FRAGMENT = 2
    }
}