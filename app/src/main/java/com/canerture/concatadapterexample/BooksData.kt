package com.canerture.concatadapterexample

object BooksData {

    fun getAllBooks(): List<BookModel> =
        listOf(
            BookModel(
                bookName = "Şeker Portakalı",
                bookAuthor = "José Mauro de Vasconcelos",
                bookPublisher = "Can Yayınları",
                bookPrice = "12",
                bookImageUrl = "https://i.idefix.com/cache/500x400-0/originals/0000000064031-1.jpg"
            ),
            BookModel(
                bookName = "Puslu Kıtalar Atlası",
                bookAuthor = "Heather McElhatton",
                bookPublisher = "April Yayıncılık",
                bookPrice = "27.95",
                bookImageUrl = "https://i.idefix.com/cache/500x400-0/originals/0000000061857-1.jpg"
            ),
            BookModel(
                bookName = "Zamanın Kısa Tarihi",
                bookAuthor = "Stephen Hawking",
                bookPublisher = "Doğan Kitap",
                bookPrice = "29.64",
                bookImageUrl = "https://i.idefix.com/cache/500x400-0/originals/0000000562120-1.jpg"
            ),
            BookModel(
                bookName = "Dune",
                bookAuthor = "Frank Herbert",
                bookPublisher = "İthaki Yayınları",
                bookPrice = "39.00",
                bookImageUrl = "https://i.idefix.com/cache/500x400-0/originals/0000000662978-1.jpg"
            ),
            BookModel(
                bookName = "Saatleri Ayarlama Enstitüsü",
                bookAuthor = "Ahmet Hamdi Tanpınar",
                bookPublisher = "Dergah Yayınları",
                bookPrice = "38.50",
                bookImageUrl = "https://i.idefix.com/cache/500x400-0/originals/0000000027135-1.jpg"
            ),
            BookModel(
                bookName = "Körlük",
                bookAuthor = "Jose Saramago",
                bookPublisher = "Kırmızı Kedi",
                bookPrice = "39.00",
                bookImageUrl = "https://i.idefix.com/cache/500x400-0/originals/0001704045001-1.jpg"
            )
        )

    fun getBestSellers(): List<BookModel> {
        val bestSellers = arrayListOf<BookModel>()

        getAllBooks().shuffled().let {
            for (i in 0..3) {
                bestSellers.add(it[i])
            }
        }

        return bestSellers
    }

}