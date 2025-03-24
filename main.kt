package com.example.adddata

import android.os.Bundle
import android.widget.*
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var editText: EditText
    private lateinit var buttonAdd: Button
    private lateinit var listView: ListView
    private val itemList = ArrayList<String>() // Menyimpan daftar item
    private lateinit var adapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        // Inisialisasi komponen UI
        editText = findViewById(R.id.editText)
        buttonAdd = findViewById(R.id.buttonAdd)
        listView = findViewById(R.id.listView)

        // Adapter untuk ListView
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, itemList)
        listView.adapter = adapter

        // Event klik tombol tambah data
        buttonAdd.setOnClickListener {
            val newItem = editText.text.toString().trim()
            if (newItem.isNotEmpty()) {
                itemList.add(newItem) // Tambahkan ke ArrayList
                adapter.notifyDataSetChanged() // Perbarui ListView
                editText.text.clear() // Reset input
            } else {
                Toast.makeText(this, "Masukkan data terlebih dahulu!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
