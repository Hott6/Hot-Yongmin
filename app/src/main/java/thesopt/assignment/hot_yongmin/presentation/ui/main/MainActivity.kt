package thesopt.assignment.hot_yongmin.presentation.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import thesopt.assignment.hot_yongmin.R
import thesopt.assignment.hot_yongmin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private var position = FIRST_FRAGMENT
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initTransaction()
    }

    fun initTransaction(){
        val fragment1 = FollowerFragment()
        val fragment2 = RepoFragment()

        supportFragmentManager.beginTransaction().add(R.id.fragmentContainerView, fragment1).commit()

        binding.btnFragmentChange.setOnClickListener{
            val transaction = supportFragmentManager.beginTransaction()

            when(position){
                FIRST_FRAGMENT ->{
                    transaction.replace(R.id.fragmentContainerView, fragment2)
                    position = SECOND_FRAGMENT
                }
                SECOND_FRAGMENT ->{
                    transaction.replace(R.id.fragmentContainerView, fragment1)
                    position= FIRST_FRAGMENT
                }
            }
            transaction.commit()
        }
    }

    companion object{
        const val FIRST_FRAGMENT = 1
        const val SECOND_FRAGMENT = 2
    }
}