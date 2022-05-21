package thesopt.assignment.hot_yongmin.presentation.ui.main.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import thesopt.assignment.hot_yongmin.databinding.FragmentFollowersBinding
import thesopt.assignment.hot_yongmin.presentation.ui.main.profile.HorizontalItemDecoration
import thesopt.assignment.hot_yongmin.presentation.ui.main.profile.VerticalItemDecoration

class FollowersFragment : Fragment() {
    private var _binding : FragmentFollowersBinding? = null
    private val binding get() = _binding!!
    private lateinit var followersAdapter: FollowersAdapter
    private val homeViewModel by viewModels<HomeViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding=FragmentFollowersBinding.inflate(layoutInflater)
        homeViewModel.connectNetwork()
        initAdapter()
        return binding.root
    }

    private fun initAdapter(){
        followersAdapter = FollowersAdapter()
        binding.rvFollowers.adapter=followersAdapter
        binding.rvFollowers.addItemDecoration(HorizontalItemDecoration(24, 2))
        binding.rvFollowers.addItemDecoration(VerticalItemDecoration(10, 2))

        homeViewModel.followersData.observe(viewLifecycleOwner){
            followersAdapter.submitList(it)
        }
    }
}
