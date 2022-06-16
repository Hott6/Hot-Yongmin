package thesopt.assignment.hot_yongmin.presentation.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.viewpager2.widget.ViewPager2
import thesopt.assignment.hot_yongmin.R
import thesopt.assignment.hot_yongmin.data.local.database.GithubSharedPreferences
import thesopt.assignment.hot_yongmin.databinding.ActivityMainBinding
import thesopt.assignment.hot_yongmin.presentation.ui.main.camera.CameraFragment
import thesopt.assignment.hot_yongmin.presentation.ui.main.home.HomeFragment
import thesopt.assignment.hot_yongmin.presentation.ui.main.profile.ProfileFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var vpAdapter:VpAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initAdapter()
        initBottomNavi()
    }

    private fun initAdapter(){
        val fragmentList = listOf(ProfileFragment(), HomeFragment(), CameraFragment())
        vpAdapter= VpAdapter(this)
        vpAdapter.fragments.addAll(fragmentList)
        binding.vpMain.adapter=vpAdapter
    }

    private fun initBottomNavi(){
        binding.vpMain.registerOnPageChangeCallback(object:ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position:Int) {
                binding.bnvMain.menu.getItem(position).isChecked=true
            }
        })

        binding.bnvMain.setOnItemSelectedListener {
            when(it.itemId){
                R.id.menu_android->{
                    binding.vpMain.currentItem= PROFILE_FRAGMENT
                    return@setOnItemSelectedListener true
                }
                R.id.menu_list->{
                    binding.vpMain.currentItem= HOME_FRAGMENT
                    return@setOnItemSelectedListener true
                }
                else->{
                    binding.vpMain.currentItem= CAMERA_FRAGMENT
                    return@setOnItemSelectedListener true
                }
            }
        }
    }

    companion object{
        const val PROFILE_FRAGMENT = 0
        const val HOME_FRAGMENT = 1
        const val CAMERA_FRAGMENT = 2
    }
}