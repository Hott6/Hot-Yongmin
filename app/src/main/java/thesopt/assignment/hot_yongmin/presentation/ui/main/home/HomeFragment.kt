package thesopt.assignment.hot_yongmin.presentation.ui.main.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.tabs.TabLayoutMediator
import thesopt.assignment.hot_yongmin.R
import thesopt.assignment.hot_yongmin.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private var _binding : FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var tabViewPagerAdapter : TabVpAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentHomeBinding.inflate(layoutInflater)
        initAdapter()
        initTabLayout()
        return binding.root
    }

    private fun initAdapter(){
        val fragmentsList = listOf(FollowersFragment(), Sample2Fragment())
        tabViewPagerAdapter = TabVpAdapter(this)
        tabViewPagerAdapter.fragmentsList.addAll(fragmentsList)
        binding.vpHome.adapter=tabViewPagerAdapter
    }

    private fun initTabLayout(){
        val tabLabel = listOf(resources.getString(R.string.follower), resources.getString(R.string.following))
        TabLayoutMediator(binding.layoutTab, binding.vpHome){
            tab, position->tab.text = tabLabel[position]
        }.attach()
    }
}