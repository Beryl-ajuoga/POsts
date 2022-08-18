package dev.beryl.myposts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle


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
    val commentId=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityCommentBinding.inflate(layoutInflater)
        setContentView(binding.root)
        obtainPostId()
        fetchPost()
        getComment()
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
                    binding.tvTitle.text=post.title
                    binding.tvBody.text =post.body

                }
            }

            override fun onFailure(call: Call<Post>, t:Throwable) {
                TODO("Not yet implemented")
            }
        })

            }
    }
fun getComment(){
    var APIClient=APIClient.buildApiClient(APIInterface::class.java)
    var request = APIClient.getPostById(postId)

    request.enqueue(object: Callback<Post> {
        override fun onResponse(call: Call<Post>, response: Response<Post>) {
            if (response.isSuccessful){
                val post=response.body()
//                    Toast.makeText(applicationContext,"fetched ${post} post",
//                        Toast.LENGTH_LONG).show()
                if (post != null) {
                    binding.tvname.text =post.title
                    binding.tvboddy.text=post.body
                }

            }
        }

        override fun onFailure(call: Call<Post>, t: Throwable) {
//                Toast.makeText(baseContext,t.message,Toast.LENGTH_LONG).show()

        }

    })

}
}


