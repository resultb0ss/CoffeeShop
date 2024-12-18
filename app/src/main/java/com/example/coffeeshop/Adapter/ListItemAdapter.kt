package com.example.coffeeshop.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.coffeeshop.Activity.DetailActivity
import com.example.coffeeshop.Model.ItemsModel
import com.example.coffeeshop.databinding.ViewholderItemBinding


class ListItemAdapter(val items: MutableList<ItemsModel>) :
    RecyclerView.Adapter<ListItemAdapter.ViewHolder>() {

    private var context: Context? = null

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        context = parent.context
        val binding =
            ViewholderItemBinding.inflate(LayoutInflater.from(context), parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        val item = items[position]
        holder.binding.titleText.text = item.title
        holder.binding.priceText.text = "$" + item.price.toString()
        holder.binding.subtitleText.text = item.extra

        Glide.with(holder.itemView.context).load(item.picUrl[0]).into(holder.binding.image)

        holder.itemView.setOnClickListener{
            val intent = Intent(holder.itemView.context, DetailActivity::class.java)
            intent.putExtra("object", item)
            holder.itemView.context.startActivity(intent)

        }
    }

    override fun getItemCount(): Int = items.size


    class ViewHolder(val binding: ViewholderItemBinding) : RecyclerView.ViewHolder(binding.root) {

    }
}