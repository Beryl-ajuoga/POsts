package dev.beryl.myposts

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Retrofit

//
//import android.view.LayoutInflater
//import android.view.ViewGroup
//import androidx.recyclerview.widget.RecyclerView
//import retrofit2.Retrofit

class RetrofitViewHolder(var postList: List<Post>):RecyclerView.Adapter<(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):RetrofitViewHolder{
        var binding=RetrofitPostItem.inflate(LayoutInflater.from(parent.context) ,parent,false)

    }

}
//
//class RetrofitRvAdapter(var postList: List<Post>):RecyclerView.Adapter<(){
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RetrofitViewHolder {
//        var  binding =RetrofitPostItemBinding.inflate(LayoutInflater.from(parent.context) ,parent,false)

//    }
//}
