package dev.beryl.myposts

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import dev.beryl.myposts.databinding.PostListItemsBinding


class PostRvAdapter(var postList: List<Post>) :
    RecyclerView.Adapter<PostViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        var binding = PostListItemsBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return PostViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        var context = holder.itemView.context
        var currentPost = postList.get(position)
        with(holder.binding) {
            tvName.text = currentPost.userID.toString()
            tvWords.text = currentPost.id.toString()
            tvNumber.text = currentPost.title
            tvTittle.text = currentPost.body
//
        }

        holder.binding.imageView4.setOnClickListener{
            Toast
                .makeText(context, "You have clicked on my face", Toast.LENGTH_LONG)
                .show()
        }
        }

    override fun getItemCount(): Int {
        return postList.size
    }

}

class PostViewHolder(var binding: PostListItemsBinding) :
    RecyclerView.ViewHolder(binding.root)


