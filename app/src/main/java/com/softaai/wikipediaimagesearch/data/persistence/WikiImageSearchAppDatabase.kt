package com.softaai.wikipediaimagesearch.data.persistence

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.softaai.wikipediaimagesearch.model.Pages


@Database(entities = [Pages::class], version = 1, exportSchema = false)
abstract class WikiImageSearchAppDatabase : RoomDatabase() {

    abstract fun getPagesDao(): PagesDao

    companion object {
        const val DB_NAME = "wiki_image_search_app_database"

        @Volatile
        private var INSTANCE: WikiImageSearchAppDatabase? = null

        fun getInstance(context: Context): WikiImageSearchAppDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }

            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    WikiImageSearchAppDatabase::class.java,
                    DB_NAME
                ).build()

                INSTANCE = instance
                return instance
            }
        }
    }
}
