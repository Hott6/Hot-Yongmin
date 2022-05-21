package thesopt.assignment.hot_yongmin.presentation.ui.main.profile

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import thesopt.assignment.hot_yongmin.data.local.entity.RepoData
import thesopt.assignment.hot_yongmin.databinding.ItemGithubRepoBinding

class RepoAdapter:RecyclerView.Adapter<RepoAdapter.RepoViewHolder>() {
    var repoList = mutableListOf<RepoData>()

    class RepoViewHolder(private val binding : ItemGithubRepoBinding) : RecyclerView.ViewHolder(binding.root){
        fun onBind(data: RepoData){
            with(binding){
                tvRepoDescription.text=data.repoDescription
                tvRepoTitle.text=data.repoTitle
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepoViewHolder {
        val binding = ItemGithubRepoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RepoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RepoViewHolder, position: Int) {
        holder.onBind(repoList[position])
    }

    override fun getItemCount(): Int {
        return repoList.size
    }
}