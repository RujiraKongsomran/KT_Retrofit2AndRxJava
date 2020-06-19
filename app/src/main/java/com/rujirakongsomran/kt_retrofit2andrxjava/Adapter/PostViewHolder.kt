package com.rujirakongsomran.kt_retrofit2andrxjava.Adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.post_layout.view.*

class PostViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val tvTitle = itemView.tvTitle
    val tvContent = itemView.tvContent
    val tvAuthor = itemView.tvAuthor
}