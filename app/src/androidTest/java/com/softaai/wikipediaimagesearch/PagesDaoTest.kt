package com.softaai.wikipediaimagesearch

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.matcher.ViewMatchers.assertThat
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.softaai.wikipediaimagesearch.data.persistence.WikiImageSearchAppDatabase
import com.softaai.wikipediaimagesearch.model.*
import com.squareup.moshi.Json
import kotlinx.coroutines.runBlocking
import org.hamcrest.CoreMatchers.equalTo
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class PagesDaoTest {

    private lateinit var mDatabase: WikiImageSearchAppDatabase

    @Before
    fun init() {
        mDatabase = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            WikiImageSearchAppDatabase::class.java
        ).build()
    }

    @Test
    @Throws(InterruptedException::class)
    fun insert_and_get_pages() = runBlocking {

        val pages = Pages(
            1,
            X11903589(1, 1, 1, ""),
            X13260340(1, 1, 1, Thumbnail(1,"",1), ""),
            X1425939(1, 1, 1, ""),
            X14533(1, 1, 1, ThumbnailX(1,"",1), ""),
            X149333(1, 1, 1, ThumbnailXX(1,"",1), ""),
            X161022(1, 1, 1, ThumbnailXXX(1,"",1), ""),
            X21883857(1, 1, 1, ThumbnailXXXX(1,"",1), ""),
            X407754(1, 1, 1, ""),
            X57707(1, 1, 1, ThumbnailXXXXX(1,"",1), ""),
            X590246(1, 1, 1, ThumbnailXXXXXX(1,"",1), "")
        )

        mDatabase.getPagesDao().addPages(pages)

        val dbPages = mDatabase.getPagesDao().getAllPages()

        assertThat(dbPages, equalTo(pages))
    }


    @After
    fun cleanup() {
        mDatabase.close()
    }
}
