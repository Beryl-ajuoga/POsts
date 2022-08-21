package dev.beryl.myposts

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

//
//import android.view.LayoutInflater
//import android.view.ViewGroup
//import androidx.recyclerview.widget.RecyclerView
//import retrofit2.Retrofit

class RetrofitRvAdapter(var postList: List<Post>):RecyclerView.Adapter<RetrofitViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RetrofitViewHolder {
        var  bindingView = RetrofitPostItemBinding.inflate(LayoutInflater.from(parent.context) ,parent,false)

    }
}
