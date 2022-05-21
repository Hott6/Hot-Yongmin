package thesopt.assignment.hot_yongmin.presentation.ui.main.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import thesopt.assignment.hot_yongmin.data.remote.data.entity.home.ResponseGithubFollowers
import thesopt.assignment.hot_yongmin.databinding.ItemGithubFollowersBinding

class FollowersAdapter :
    ListAdapter<ResponseGithubFollowers.Data, FollowersAdapter.FollowersViewHolder>(
        FollowersComparator()
    ) {

    class FollowersViewHolder(private val binding: ItemGithubFollowersBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: ResponseGithubFollowers.Data) {
            binding.followersData = data
        }
    }

    private class FollowersComparator : DiffUtil.ItemCallback<ResponseGithubFollowers.Data>() {
        override fun areItemsTheSame(
            oldItem: ResponseGithubFollowers.Data,
            newItem: ResponseGithubFollowers.Data
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: ResponseGithubFollowers.Data,
            newItem: ResponseGithubFollowers.Data
        ): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FollowersViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemGithubFollowersBinding.inflate(layoutInflater, parent, false)
        return FollowersViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FollowersViewHolder, position: Int) {
        return holder.onBind(getItem(position))
    }
}