package com.canerture.concatadapterexample

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.canerture.concatadapterexample.databinding.ItemBestSellerBinding
import com.squareup.picasso.Picasso

class BestSellersItemAdapter : RecyclerView.Adapter<BestSellersItemAdapter.BestSellersItemDesign>() {

    private val bestSellersList = ArrayList<BookModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BestSellersItemDesign {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemBestSellerBinding = ItemBestSellerBinding.inflate(layoutInflater, parent, false)
        return BestSellersItemDesign(itemBestSellerBinding)
    }

    override fun onBindViewHolder(holder: BestSellersItemDesign, position: Int) {
        holder.bind(bestSellersList[position])
    }

    class BestSellersItemDesign(private var itemBestSellerBinding: ItemBestSellerBinding) :
        RecyclerView.ViewHolder(itemBestSellerBinding.root) {

        fun bind(book: BookModel) {

            with(itemBestSellerBinding) {

                bookAuthorText.text = book.bookAuthor
                bookNameText.text = book.bookName
                "${book.bookPrice} ₺".also { bookPriceText.text = it }

                Picasso.get().load(book.bookImageUrl).into(bookImageView)
            }
        }
    }

    override fun getItemCount(): Int = bestSellersList.size

    fun updateList(list: List<BookModel>) {
        bestSellersList.clear()
        bestSellersList.addAll(list)
        notifyItemRangeChanged(0, bestSellersList.size - 1)
    }
}