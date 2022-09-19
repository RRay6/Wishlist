package com.example.wishlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var items: List<Item>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Lookup the RecyclerView in activity layout
        val itemsRv = findViewById<RecyclerView>(R.id.itemsRv)
        // Fetch the list of emails

        val fetcher = ItemFetcher;
        items = fetcher.getItems()
        // Create adapter passing in the list of emails
        var adapter = ItemAdapter(items)
        // Attach the adapter to the RecyclerView to populate items
        itemsRv.adapter = adapter
        // Set layout manager to position the items
        itemsRv.layoutManager = LinearLayoutManager(this)

        val button = findViewById<Button>(R.id.button)
        // set on-click listener
        button.setOnClickListener {
            // your code to perform when the user clicks on the button
            // Toast.makeText(this@MainActivity, "You clicked me.", Toast.LENGTH_SHORT).show()

            val name = findViewById<EditText>(R.id.item_name)
            val price = findViewById<EditText>(R.id.item_price)
            val url = findViewById<EditText>(R.id.item_url)

            if (name.text.toString() == "" || price.text.toString() == "")
            {
                Toast.makeText(this@MainActivity, "Please input name and/or price!", Toast.LENGTH_SHORT).show()
            }
            else
            {
                fetcher.addItem(name.text.toString(), price.text.toString(), url.text.toString())
                items = fetcher.getItems()

                name.setText("")
                price.setText("")
                url.setText("")

                // Toast.makeText(this@MainActivity, name, Toast.LENGTH_SHORT).show()

                adapter = ItemAdapter(items)
                itemsRv.adapter = adapter
                itemsRv.layoutManager = LinearLayoutManager(this)
            }
        }
    }
}