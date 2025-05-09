package com.yehezkiel0091.mybuku.ui.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.yehezkiel0091.mybuku.database.BookDao
import com.yehezkiel0091.mybuku.model.Book
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn

class MainViewModel(dao: BookDao) : ViewModel() {

    val data: StateFlow<List<Book>> = dao.getAllBooks().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(),
        initialValue = emptyList()
    )
}
