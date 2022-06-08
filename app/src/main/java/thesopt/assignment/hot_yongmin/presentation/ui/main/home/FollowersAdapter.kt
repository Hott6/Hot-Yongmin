package thesopt.assignment.hot_yongmin.presentation.ui.main.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import thesopt.assignment.hot_yongmin.data.remote.data.entity.home.ResponseGithubFollowers
import thesopt.assignment.hot_yongmin.databinding.ItemGithubFollowersBinding

class FollowersAdapter(val itemClick : (ResponseGithubFollowers)->Unit) :
    ListAdapter<ResponseGithubFollowers, FollowersAdapter.FollowersViewHolder>(
        FollowersComparator()
    ) {

    class FollowersViewHolder(private val binding: ItemGithubFollowersBinding, private val itemClick : (ResponseGithubFollowers)->Unit) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: ResponseGithubFollowers) {
            binding.followersData = data
            Glide.with(binding.ivProfile.context).load(data.profileImage).into(binding.ivProfile)
            binding.root.setOnClickListener{
                itemClick(data)
            }
        }
    }

    private class FollowersComparator : DiffUtil.ItemCallback<ResponseGithubFollowers>() {
        override fun areItemsTheSame(
            oldItem: ResponseGithubFollowers,
            newItem: ResponseGithubFollowers
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: ResponseGithubFollowers,
            newItem: ResponseGithubFollowers
        ): Boolean {
            return oldItem == newItem
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FollowersViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemGithubFollowersBinding.inflate(layoutInflater, parent, false)
        return FollowersViewHolder(binding, itemClick)
    }

    override fun onBindViewHolder(holder: FollowersViewHolder, position: Int) {
        return holder.onBind(getItem(position))
    }
}