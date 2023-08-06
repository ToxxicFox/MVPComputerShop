package com.example.mvpcomputershop.presentation.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mvpcomputershop.databinding.ProductItemBinding
import com.example.mvpcomputershop.domain.entity.ProductEntity

class ProductViewAdapter:
    RecyclerView.Adapter<ProductViewAdapter.ProductViewHolder>() {

    private var orderItems = ArrayList<ProductEntity>()

    @SuppressLint("NotifyDataSetChanged")
    fun setUpdateList(orderItems: ArrayList<ProductEntity>) {
        this.orderItems.addAll(orderItems)
        notifyDataSetChanged()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun clearList() {
        orderItems.clear()
        notifyDataSetChanged()
    }

    class ProductViewHolder(private val binding: ProductItemBinding):
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: ProductEntity) {
            binding.productTitle.text = data.title
            binding.productPrice.text = data.price.toString() + RUB
            val url = data.img + EXTENSION

            Glide.with(binding.productImg)
                .load(url)
                .timeout(6000000)
                .into(binding.productImg)
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ProductViewHolder {
        val detailOrderItemBinding =
            ProductItemBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return ProductViewHolder(detailOrderItemBinding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(orderItems[position])
    }

    override fun getItemCount(): Int {
        return orderItems.size
    }

    companion object {
        const val EXTENSION = ".jpg"
        const val RUB = "₽"
    }

}