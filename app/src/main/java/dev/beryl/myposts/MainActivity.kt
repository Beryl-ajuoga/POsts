package dev.beryl.myposts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dev.beryl.myposts.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getPost()
    }
    fun getPost(){
        var retrofit = ApiClient.buildApiClient(ApiInterface::class.java)
        var request = retrofit.getPosts()

        request.enqueue(object : Callback<List<Post>> {
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                if (response.isSuccessful){
                    var posts = response.body()
                    Toast.makeText(baseContext, "fetched ${posts!!.size} post",
                        Toast.LENGTH_LONG).show()


                    var postAdapter = PostRvAdapter(posts)
                    binding.rvlist.layoutManager= LinearLayoutManager(baseContext)
                    binding.rvlist.adapter  = postAdapter
                }
            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {

            }
        })
    }




}














