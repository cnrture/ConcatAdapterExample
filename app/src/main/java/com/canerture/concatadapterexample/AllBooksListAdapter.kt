package com.canerture.concatadapterexample

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.canerture.concatadapterexample.databinding.ListAllBooksBinding

class AllBooksListAdapter : RecyclerView.Adapter<AllBooksListAdapter.AllBooksListDesign>() {

    private val allBooksList = ArrayList<BookModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AllBooksListDesign {
        val layoutInflater = LayoutInflater.from(parent.context)
        val listAllBooksBinding = ListAllBooksBinding.inflate(layoutInflater, parent, false)
        return AllBooksListDesign(listAllBooksBinding)
    }

    override fun onBindViewHolder(holder: AllBooksListDesign, position: Int) {
        holder.bind(allBooksList)
    }

    class AllBooksListDesign(private var listAllBooksBinding: ListAllBooksBinding) :
        RecyclerView.ViewHolder(listAllBooksBinding.root) {

        fun bind(allBooksList: List<BookModel>) {

            //Tüm Kitapları listelemek için kullandığımız RecyclerView'ı GridLayoutManager ile oluşturuyoruz.
            //Sonrasında adapter olarak AllBooksItemAdapter'ı yerleştiriyoruz ve listemizi gönderiyoruz.
            listAllBooksBinding.rvAllBooks.apply {

                layoutManager = GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false)

                adapter = AllBooksItemAdapter().also {
                    it.updateList(allBooksList)
                }
            }
        }
    }

    //AllBooksItemAdapter ile doldurduğumuz RecyclerView burası ve bu ReyclerView 1 kere yazdırılacak.
    override fun getItemCount(): Int = 1

    fun updateList(list: List<BookModel>) {
        allBooksList.clear()
        allBooksList.addAll(list)
    }
}