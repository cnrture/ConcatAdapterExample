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

    //HeaderAdapter üzerinden 2 nesne oluşturuyoruz 2 başlık için
    private val allBooksHeaderAdapter by lazy { HeaderAdapter("Tüm Kitaplar") }
    private val bestSellersHeaderAdapter by lazy { HeaderAdapter("Çok Satanlar") }

    private var concatAdapter = ConcatAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        allBooksAdapter.updateList(BooksData.getAllBooks())
        bestSellersAdapter.updateList(BooksData.getBestSellers())

        //concatAdapter değişkenimize oluşturduğumuz adapterları gösterim sırasına göre dahil ediyoruz.
        concatAdapter = ConcatAdapter(
            bestSellersHeaderAdapter,
            bestSellersAdapter,
            allBooksHeaderAdapter,
            allBooksAdapter
        )

        //concatAdapter'a adapter ekleme
        //concatAdapter.addAdapter(allBooksAdapter)

        //concatAdapter'a index belirterek adapter ekleme
        //concatAdapter.addAdapter(3, allBooksAdapter)

        //concatAdapter'dan adapter silme
        //concatAdapter.removeAdapter(allBooksAdapter)

        //Activity içerisindeki RecyclerView'a oluşturduğumuz concatAdapter'ı yerleştiriyoruz.
        binding.rvConcat.apply {
            layoutManager =
                LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
            adapter = concatAdapter
        }

    }
}