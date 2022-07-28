package dev.beryl.myposts

import android.media.audiofx.DynamicsProcessing

data class Post(
    var userID:Int,
    var id:Int,
    var title:String,
    var body:String
)
data class Comment(
    var postID:Int,
    var id:Int,
    var name:String,
    var email:String,
     var body: String,
)

