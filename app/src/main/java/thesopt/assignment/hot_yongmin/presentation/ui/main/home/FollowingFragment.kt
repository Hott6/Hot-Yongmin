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
import thesopt.assignment.hot_yongmin.databinding.FragmentFollowingBinding
import thesopt.assignment.hot_yongmin.presentation.ui.main.profile.HorizontalItemDecoration
import thesopt.assignment.hot_yongmin.presentation.ui.main.profile.VerticalItemDecoration

class FollowingFragment : Fragment() {
    private var _binding: FragmentFollowingBinding? = null
    private val binding get() = _binding ?: error("binding이 초기화 되지 않았습니다.")
    private val homeViewModel by viewModels<HomeViewModel>()
    private lateinit var followingAdapter: FollowingAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFollowingBinding.inflate(layoutInflater)
        homeViewModel.initFollowingNetwork()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        observeData()
    }

    private fun initAdapter() {
        followingAdapter = FollowingAdapter(itemClick = {
            val address: Intent =
                Uri.parse(it.profileLink).let { webpage -> Intent(Intent.ACTION_VIEW, webpage) }
            startActivity(address)
        })
        binding.rvFollowers.adapter = followingAdapter
        val sizeH = resources.getDimensionPixelSize(R.dimen.margin_24)
        val sizeV = resources.getDimensionPixelSize(R.dimen.margin_30)
        binding.rvFollowers.addItemDecoration(HorizontalItemDecoration(sizeH, 2))
        binding.rvFollowers.addItemDecoration(VerticalItemDecoration(sizeV, 2))
    }

    private fun observeData() {
        homeViewModel.followingData.observe(viewLifecycleOwner) {
            followingAdapter.submitList(it)
        }
    }
}