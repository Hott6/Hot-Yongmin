package thesopt.assignment.hot_yongmin.presentation.ui.main.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import thesopt.assignment.hot_yongmin.R
import thesopt.assignment.hot_yongmin.data.entity.FollowerData
import thesopt.assignment.hot_yongmin.databinding.FragmentFollowerBinding

class FollowerFragment : Fragment() {
    private var _binding : FragmentFollowerBinding? = null
    private val binding get() = _binding!!
    private lateinit var followerAdapter: FollowerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFollowerBinding.inflate(layoutInflater, container, false)
        initAdapter()
        return binding.root
    }

    private fun initAdapter(){
        val followerAdapter = FollowerAdapter()
        with(binding){
            rvFollower.adapter = followerAdapter
            rvFollower.addItemDecoration(VerticalItemDecoration(resources.getDimensionPixelOffset(R.dimen.margin_15), 1))
            rvFollower.addItemDecoration(HorizontalItemDecoration(resources.getDimensionPixelOffset(R.dimen.margin_30), 1))
        }

        followerAdapter.followerList.addAll(
            listOf(
                FollowerData("권용민", "30기 OB"),
                FollowerData("김수빈", "30기 OB"),
                FollowerData("최윤정", "30기 YB"),
                FollowerData("최유리", "30기 YB"),
                FollowerData("이준원", "30기 YB"),
                FollowerData("이강민", "30기 파트장")
            )
        )
        followerAdapter.notifyDataSetChanged()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }
}