package com.rujirakongsomran.kt_retrofit2andrxjava.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rujirakongsomran.kt_retrofit2andrxjava.Model.Post
import com.rujirakongsomran.kt_retrofit2andrxjava.R

class PostAdapter(internal var context: Context, internal var postList: List<Post>) :
    RecyclerView.Adapter<PostViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        var itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.post_layout, parent, false)
        return PostViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return postList.size
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        holder.tvAuthor.text = postList[position].userId.toString()
        holder.tvTitle.text = postList[position].title
        holder.tvContent.text = StringBuilder(postList[position].body.substring(0, 20))
            .append("...").toString()

    }

}