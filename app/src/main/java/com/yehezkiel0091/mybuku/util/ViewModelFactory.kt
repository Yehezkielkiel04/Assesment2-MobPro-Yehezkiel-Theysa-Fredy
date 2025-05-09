package com.yehezkiel0091.mybuku.util

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.yehezkiel0091.mybuku.database.BookDatabase
import com.yehezkiel0091.mybuku.ui.screen.DetailViewModel
import com.yehezkiel0091.mybuku.ui.screen.MainViewModel

class ViewModelFactory(
    private val context: Context
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val dao = BookDatabase.getInstance(context).dao
        return when {
            modelClass.isAssignableFrom(MainViewModel::class.java) -> {
                MainViewModel(dao) as T
            }
            modelClass.isAssignableFrom(DetailViewModel::class.java) -> {
                DetailViewModel(dao) as T
            }
            else -> throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}
