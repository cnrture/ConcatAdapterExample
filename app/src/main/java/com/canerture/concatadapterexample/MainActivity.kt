package com.canerture.concatadapterexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.canerture.concatadapterexample.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val allBooksAdapter by lazy { AllBooksListAdapter() }
    private val bestSellersAdapter by lazy { BestSellersListAdapter() }

    private val allBooksHeaderAdapter by lazy { HeaderAdapter("Tüm Kitaplar") }
    private val bestSellersHeaderAdapter by lazy { HeaderAdapter("Çok Satanlar") }

    private var concatAdapter = ConcatAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        allBooksAdapter.updateList(BooksData.getAllBooks())
        bestSellersAdapter.updateList(BooksData.getBestSellers())

        concatAdapter = ConcatAdapter(
            bestSellersHeaderAdapter,
            bestSellersAdapter,
            allBooksHeaderAdapter,
            allBooksAdapter
        )

        //concatAdapter.addAdapter(allBooksAdapter)
        //concatAdapter.addAdapter(3, allBooksAdapter)

        //concatAdapter.removeAdapter(allBooksAdapter)

        binding.rvConcat.apply {
            layoutManager =
                LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
            adapter = concatAdapter
        }

    }
}