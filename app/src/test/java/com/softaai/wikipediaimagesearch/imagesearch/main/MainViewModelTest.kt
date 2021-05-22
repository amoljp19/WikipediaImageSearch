package com.softaai.wikipediaimagesearch.imagesearch.main

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.softaai.wikipediaimagesearch.data.network.Resource
import com.softaai.wikipediaimagesearch.data.network.State
import com.softaai.wikipediaimagesearch.data.repository.ImageSearchRepository
import com.softaai.wikipediaimagesearch.imagesearch.CoroutineTestRule
import com.softaai.wikipediaimagesearch.model.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runBlockingTest
import org.hamcrest.MatcherAssert
import org.hamcrest.core.IsEqual
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.ArgumentMatchers
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever


@RunWith(JUnit4::class)
class MainViewModelTest {

    @Mock
    private lateinit var mainViewModel: MainViewModel

    @Mock
    private lateinit var imageSearchRepository: ImageSearchRepository

    @Mock
    private lateinit var observer: Observer<State<Pages>>

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()


    @ExperimentalCoroutinesApi
    @get:Rule
    var coroutineTestRule = CoroutineTestRule()


    @Before
    fun setup() {

        MockitoAnnotations.initMocks(this)
        mainViewModel = Mockito.spy(MainViewModel(imageSearchRepository))

    }


    @ExperimentalCoroutinesApi
    @Test
    fun pagesLiveData_ShouldPostLoading() {

        coroutineTestRule.testDispatcher.runBlockingTest {

            //Given
            val data = mock<Flow<Resource<Pages>>>()

            whenever(imageSearchRepository.getPages()).thenReturn(data)


            //When
            mainViewModel.getPages()

            //Then
            mainViewModel.pagesLiveData.observeForever(observer)
            Mockito.verify(observer).onChanged(ArgumentMatchers.refEq(State.loading()))


        }
    }


    @ExperimentalCoroutinesApi
    @Test
    fun pagesLiveData_ShouldPostSuccess() {

        coroutineTestRule.testDispatcher.runBlockingTest {

            val pages = Pages(
                1,
                X11903589(1, 1, 1, ""),
                X13260340(1, 1, 1, Thumbnail(1, "", 1), ""),
                X1425939(1, 1, 1, ""),
                X14533(1, 1, 1, ThumbnailX(1, "", 1), ""),
                X149333(1, 1, 1, ThumbnailXX(1, "", 1), ""),
                X161022(1, 1, 1, ThumbnailXXX(1, "", 1), ""),
                X21883857(1, 1, 1, ThumbnailXXXX(1, "", 1), ""),
                X407754(1, 1, 1, ""),
                X57707(1, 1, 1, ThumbnailXXXXX(1, "", 1), ""),
                X590246(1, 1, 1, ThumbnailXXXXXX(1, "", 1), "")
            )

            whenever(imageSearchRepository.getPages()) doReturn flowOf(
                Resource.Success(
                    pages
                )
            )

            mainViewModel.getPages()


            val observer = object : Observer<State<Pages>> {
                override fun onChanged(data1: State<Pages>) {
                    MatcherAssert.assertThat(
                        data1,
                        IsEqual(State.success(pages))
                    )
                    mainViewModel.pagesLiveData.removeObserver(this)
                }
            }
            mainViewModel.pagesLiveData.observeForever(observer)

        }
    }


    @ExperimentalCoroutinesApi
    @Test
    fun pagesLiveData_ShouldPostError() {

        coroutineTestRule.testDispatcher.runBlockingTest {

            val message = "error message"

            whenever(imageSearchRepository.getPages()) doReturn flowOf(
                Resource.Failed(
                    message
                )
            )

            mainViewModel.getPages()


            val observer = object : Observer<State<Pages>> {
                override fun onChanged(data1: State<Pages>) {
                    MatcherAssert.assertThat(data1, IsEqual(State.error(message)))
                    mainViewModel.pagesLiveData.removeObserver(this)
                }
            }
            mainViewModel.pagesLiveData.observeForever(observer)

        }

    }

}