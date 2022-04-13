package thesopt.assignment.hot_yongmin.presentation.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import thesopt.assignment.hot_yongmin.data.entity.FollowerData
import thesopt.assignment.hot_yongmin.databinding.ItemGithubFollowerBinding

class FollowerAdapter:RecyclerView.Adapter<FollowerAdapter.FollowerViewHolder>() {

    val followerList = mutableListOf<FollowerData>()

    class FollowerViewHolder(private val binding : ItemGithubFollowerBinding):RecyclerView.ViewHolder(binding.root){
        fun onBind(data:FollowerData){
            binding.tvName.text = data.name
            binding.tvIntroduction.text = data.introduction
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FollowerViewHolder {
        val binding = ItemGithubFollowerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FollowerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FollowerViewHolder, position: Int) {
        holder.onBind(followerList[position])
    }

    override fun getItemCount(): Int {
        return followerList.size
    }

}