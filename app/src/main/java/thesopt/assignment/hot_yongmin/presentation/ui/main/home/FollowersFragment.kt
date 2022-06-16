package thesopt.assignment.hot_yongmin.presentation.ui.main.home

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import thesopt.assignment.hot_yongmin.R
import thesopt.assignment.hot_yongmin.databinding.FragmentFollowersBinding
import thesopt.assignment.hot_yongmin.presentation.ui.main.profile.HorizontalItemDecoration
import thesopt.assignment.hot_yongmin.presentation.ui.main.profile.VerticalItemDecoration

class FollowersFragment : Fragment() {
    private var _binding: FragmentFollowersBinding? = null
    private val binding get() = _binding ?: error("binding이 초기화 되지 않았습니다.")
    private lateinit var followersAdapter: FollowersAdapter
    private val homeViewModel by viewModels<HomeViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFollowersBinding.inflate(layoutInflater)
        homeViewModel.initNetwork()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        observeData()
    }

    private fun initAdapter() {
        followersAdapter = FollowersAdapter(itemClick = {
            val address: Intent =
                Uri.parse(it.profileLink).let { webpage -> Intent(Intent.ACTION_VIEW, webpage) }
            startActivity(address)
        })
        binding.rvFollowers.adapter = followersAdapter
        val sizeH = resources.getDimensionPixelSize(R.dimen.margin_24)
        val sizeV = resources.getDimensionPixelSize(R.dimen.margin_30)
        binding.rvFollowers.addItemDecoration(HorizontalItemDecoration(sizeH, 2))
        binding.rvFollowers.addItemDecoration(VerticalItemDecoration(sizeV, 2))
    }

    private fun observeData() {
        homeViewModel.followersData.observe(viewLifecycleOwner) {
            followersAdapter.submitList(it)
        }
    }
}
