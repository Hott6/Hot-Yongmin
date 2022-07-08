package thesopt.assignment.hot_yongmin.presentation.ui.main.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import thesopt.assignment.hot_yongmin.data.remote.data.entity.home.ResponseGithubFollowers
import thesopt.assignment.hot_yongmin.databinding.ItemGithubFollowersBinding

class FollowingAdapter(val itemClick: (ResponseGithubFollowers) -> Unit) :
    ListAdapter<ResponseGithubFollowers, FollowingAdapter.FollowingViewHolder>(FollowingComparator()) {

    class FollowingViewHolder(
        private val binding: ItemGithubFollowersBinding,
        private val itemClick: (ResponseGithubFollowers) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: ResponseGithubFollowers) {
            binding.followersData = data
            Glide.with(binding.ivProfile.context).load(data.profileImage).into(binding.ivProfile)
            itemView.setOnClickListener {
                itemClick(data)
            }
        }
    }

    class FollowingComparator() : DiffUtil.ItemCallback<ResponseGithubFollowers>() {
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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FollowingViewHolder {
        val binding =
            ItemGithubFollowersBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FollowingViewHolder(binding, itemClick)
    }

    override fun onBindViewHolder(holder: FollowingViewHolder, position: Int) {
        return holder.onBind(getItem(position))
    }
}