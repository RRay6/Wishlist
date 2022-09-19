package com.example.wishlist

class ItemFetcher {
    companion object {
        //val name = listOf("Dahlia Cline", "Kevin Miranda", "Kaya Austin", "Laila Calderon", "Marquise Rhodes", "Fletcher Patel", "Luz Barron", "Kamren Dudley", "Jairo Foster", "Lilah Sandoval", "Ansley Blake", "Slade Sawyer", "Jaelyn Holmes", "Phoenix Bright", "Ernesto Gould")
        //val price = "Welcome to Kotlin!"
        //val url = "Welcome to the Android Kotlin Course! We're excited to have you join us and learn how to develop Android apps using Kotlin. Here are some tips to get started."

        //var items = ArrayList();
        private val items = mutableListOf<Item>()

        fun getItems(): MutableList<Item> {
            //var items : MutableList<Item> = ArrayList()

//            for (i in 0..items.size) {
//                val item = Item(name[i], price, url)
//                items.add(item)
//            }
            return items
        }

        fun addItem(name: String, price: String, url: String) {
            val item = Item(name, price, url)
            items.add(item)
        }
    }
}