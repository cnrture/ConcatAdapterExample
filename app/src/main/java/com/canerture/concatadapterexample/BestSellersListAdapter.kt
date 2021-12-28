package com.canerture.concatadapterexample

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.canerture.concatadapterexample.databinding.ListBestSellerBinding

class BestSellersListAdapter : RecyclerView.Adapter<BestSellersListAdapter.BestSellersListDesign>() {

    private val bestSellersList = ArrayList<BookModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BestSellersListDesign {
        val layoutInflater = LayoutInflater.from(parent.context)
        val listBestSellerBinding = ListBestSellerBinding.inflate(layoutInflater, parent, false)
        return BestSellersListDesign(listBestSellerBinding)
    }

    override fun onBindViewHolder(holder: BestSellersListDesign, position: Int) {
        holder.bind(bestSellersList)
    }

    class BestSellersListDesign(private var listBestSellerBinding: ListBestSellerBinding) :
        RecyclerView.ViewHolder(listBestSellerBinding.root) {

        fun bind(bestSellersList: List<BookModel>) {

            //Çok Satanları listelemek için kullandığımız RecyclerView'ı Horizontal RecyclerView ile oluşturuyoruz.
            //Sonrasında adapter olarak BestSellersItemAdapter'ı yerleştiriyoruz ve listemizi gönderiyoruz.
            listBestSellerBinding.rvBestSellers.apply {

                layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

                adapter = BestSellersItemAdapter().also {
                    it.updateList(bestSellersList)
                }
            }
        }
    }

    //BestSellersItemAdaper ile doldurduğumuz RecyclerView burası ve bu ReyclerView 1 kere yazdırılacak.
    override fun getItemCount(): Int = 1

    fun updateList(list: List<BookModel>) {
        bestSellersList.clear()
        bestSellersList.addAll(list)
    }
}