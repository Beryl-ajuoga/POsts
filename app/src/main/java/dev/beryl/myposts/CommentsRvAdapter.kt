package dev.beryl.myposts

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dev.beryl.myposts.databinding.CommentListItemBinding

class CommentsRvAdapter (var commentsList: List<Comment>
) : RecyclerView.Adapter<CommentsRvAdapter.CommentsViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentsViewHolder {
        var bindingView =
            CommentListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CommentsViewHolder(bindingView)
    }

    override fun onBindViewHolder(holder: CommentsViewHolder, position: Int) {
        var currentItem = commentsList.get(position)
        val context = holder.itemView.context


        with(holder.bindingView) {
//
            tvCommentBody.text = currentItem.body
            tvUserName.text = currentItem.postID.toString()

            val context=holder.itemView.context
            cvComments.setOnClickListener{
                val intent= Intent(context, CommentActivity::class.java)
                intent.putExtra("COMMENT_ID", currentItem.id)
                context.startActivity(intent)
            }
        }

    }

    override fun getItemCount(): Int {
        return commentsList.size
    }

    class CommentsViewHolder(var bindingView:CommentListItemBinding ) :
        RecyclerView.ViewHolder(bindingView.root) {

    }
}



