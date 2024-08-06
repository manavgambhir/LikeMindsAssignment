package com.example.myapplication1.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.myapplication1.R
import com.example.myapplication1.databinding.ItemsBinding
import com.example.myapplication1.model.ResponseItem
import retrofit2.Response

class rvAdapter(private var context: Context, val list:List<ResponseItem>): RecyclerView.Adapter<rvAdapter.rvViewHolder>() {
    class rvViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val binding = ItemsBinding.bind(itemView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): rvViewHolder {
        return rvViewHolder(LayoutInflater.from(context).inflate(R.layout.items, parent, false))
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: rvViewHolder, position: Int) {
        val item = list[position]
        holder.binding.NameTv.text = item.fullName
        Glide.with(context).load(item.image)
            .into(holder.binding.imageView)

        holder.itemView.setOnClickListener {
            //TODO
        }
    }
}