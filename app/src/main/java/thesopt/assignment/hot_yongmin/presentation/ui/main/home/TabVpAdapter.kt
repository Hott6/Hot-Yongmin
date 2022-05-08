package thesopt.assignment.hot_yongmin.presentation.ui.main.home

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class TabVpAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    val fragmentsList = mutableListOf<Fragment>()
    override fun getItemCount(): Int {
        return fragmentsList.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragmentsList[position]
    }
}