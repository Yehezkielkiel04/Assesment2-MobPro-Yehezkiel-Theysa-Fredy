package com.yehezkiel0091.mybuku.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.yehezkiel0091.mybuku.model.Book
import kotlinx.coroutines.flow.Flow

@Dao
interface BookDao {

    @Insert
    suspend fun insert(book: Book)

    @Update
    suspend fun update(book: Book)

    @Query("SELECT * FROM books ORDER BY genre ASC")
    fun getAllBooks(): Flow<List<Book>>

    @Query("SELECT * FROM books WHERE id = :id")
    suspend fun getBookById(id: Long): Book?

    @Query("DELETE FROM books WHERE id = :id")
    suspend fun deleteById(id: Long)

    @Query("SELECT * FROM books WHERE judul LIKE '%' || :query || '%'")
    fun searchBooksByTitle(query: String): Flow<List<Book>>
}
