package com.canerture.concatadapterexample

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.canerture.concatadapterexample.databinding.ItemAllBooksBinding
import com.squareup.picasso.Picasso

class AllBooksItemAdapter : RecyclerView.Adapter<AllBooksItemAdapter.AllBooksItemDesign>() {

    private val allBooksList = ArrayList<BookModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AllBooksItemDesign {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemAllBooksBinding = ItemAllBooksBinding.inflate(layoutInflater, parent, false)
        return AllBooksItemDesign(itemAllBooksBinding)
    }

    override fun onBindViewHolder(holder: AllBooksItemDesign, position: Int) {
        holder.bind(allBooksList[position])
    }

    class AllBooksItemDesign(private var itemAllBooksBinding: ItemAllBooksBinding) :
        RecyclerView.ViewHolder(itemAllBooksBinding.root) {

        fun bind(book: BookModel) {

            with(itemAllBooksBinding) {

                bookAuthorText.text = book.bookAuthor
                bookNameText.text = book.bookName
                "${book.bookPrice} ₺".also { bookPriceText.text = it }

                Picasso.get().load(book.bookImageUrl).into(bookImageView)
            }
        }
    }

    override fun getItemCount(): Int = allBooksList.size

    fun updateList(list: List<BookModel>) {
        allBooksList.clear()
        allBooksList.addAll(list)
        notifyItemRangeChanged(0, allBooksList.size - 1)
    }
}