package dev.beryl.myposts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager


import dev.beryl.myposts.databinding.ActivityCommentBinding
import dev.beryl.myposts.databinding.ActivityMainBinding
import dev.beryl.myposts.databinding.PostListItemsBinding
import retrofit2.Callback
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.POST


class CommentActivity : AppCompatActivity() {
    lateinit var binding:ActivityCommentBinding
    var postId=0
//    val commentId=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityCommentBinding.inflate(layoutInflater)
        setContentView(binding.root)
        obtainPostId()
        fetchPost()

    }
    fun obtainPostId(){
        postId=intent.extras?.getInt("POST_ID")?:0
    }
    fun fetchPost(){
        var ApiClient=ApiClient.buildApiClient(ApiInterface::class.java)
        var request = ApiClient.getPostById(postId)
        request.enqueue (object :Callback<Post>{
            override  fun onResponse(call:Call<Post>,response: Response<Post>){
                var  post=response.body()
                if (post!=null){
                    binding.tvPostTitle.text=post.title
                    binding.tvPostBody.text=post.body


                }
            }

            override fun onFailure(call: Call<Post>, t:Throwable) {

            }
        })

            }
    }

//fun getComment() {
//    var apiClient=ApiClient.buildApiClient(ApiInterface::class.java)
////    var apiClient = APIClient.buildApiClient(APInterface::class.java)
//    var request = apiClient.getComments()
//    request.enqueue(object : Callback<List<Comment>> {
//        override fun onResponse(call: Call<List<Comment>>, response: Response<List<Comment>>) {
//            if (response.isSuccessful){
//                val comment = response.body()
//                if (comment != null) {
//                    displayComments(comment)
//                }
//            }
//        }
//
//        override fun onFailure(call: Call<List<Comment>>, t: Throwable) {
//            Toast.makeText(baseContext,t.message,Toast.LENGTH_LONG).show()
//        }
//    })
//}
//fun displayComments(commentList: List<Comment>) {
//    binding.rvComments.layoutManager = LinearLayoutManager(this)
//    val commentsAdapter = CommentsRvAdapter(commentList)
//    binding.rvComments.adapter = commentsAdapter
//}





