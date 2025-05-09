package com.yehezkiel0091.mybuku.ui.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yehezkiel0091.mybuku.database.BookDao
import com.yehezkiel0091.mybuku.model.Book
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

class DetailViewModel(private val dao: BookDao) : ViewModel() {

    private val formatter = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())

    fun insert(judul: String, penulis: String, genre: String) {
        val book = Book(
            judul = judul,
            penulis = penulis,
            genre = genre,
            tanggal = formatter.format(Date())
        )

        viewModelScope.launch(Dispatchers.IO) {
            dao.insert(book)
        }
    }

    suspend fun getBuku(id: Long): Book? {
        return dao.getBookById(id)
    }

    fun update(id: Long, judul: String, penulis: String, genre: String) {
        val book = Book(
            id = id,
            judul = judul,
            penulis = penulis,
            genre = genre,
            tanggal = formatter.format(Date())
        )

        viewModelScope.launch(Dispatchers.IO) {
            dao.update(book)
        }
    }

    fun delete(id: Long) {
        viewModelScope.launch(Dispatchers.IO) {
            dao.deleteById(id)
        }
    }
}
