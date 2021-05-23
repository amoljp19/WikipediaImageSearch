package com.softaai.wikipediaimagesearch.data.persistence

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.softaai.wikipediaimagesearch.model.Pages
import kotlinx.coroutines.flow.Flow

@Dao
interface PagesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addPages(pages: Pages)

    @Query("DELETE FROM ${Pages.TABLE_NAME}")
    suspend fun deletePages()

//    @Query("SELECT * FROM ${Pages.TABLE_NAME} WHERE ID = :pageId")
//    fun getPageById(pageId: Int): Flow<Pages>

    @Query("SELECT * FROM ${Pages.TABLE_NAME}")
    fun getAllPages(): Flow<Pages>

}