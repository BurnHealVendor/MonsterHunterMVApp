package com.example.monsterhuntermvapp.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.monsterhuntermvapp.model.MotionValuesItem
import com.example.monsterhuntermvapp.rest.MotionValuesRepo
import com.example.monsterhuntermvapp.utils.MotionValuesState
import com.example.monsterhuntermvapp.utils.WeaponType
import com.google.common.truth.Truth.assertThat
import io.mockk.clearAllMocks
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import retrofit2.Response

@ExperimentalCoroutinesApi
class MVViewModelTest {

    @get:Rule var rule = InstantTaskExecutorRule()
    private val testDispatcher = UnconfinedTestDispatcher()
    private val mockRepo = mockk<MotionValuesRepo>(relaxed = true)
    private lateinit var target: MVViewModel
    var weaponType: WeaponType = WeaponType.GREAT_SWORD

    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
        target = MVViewModel(mockRepo, testDispatcher)
    }

    @After
    fun shutDown() {
        clearAllMocks()
        Dispatchers.resetMain()
    }

    @Test
    fun `getMotionValues server call returns loading`() {

        // assign
        val stateList = mutableListOf<MotionValuesState>()
        target.motionValuesLiveData.observeForever {
            stateList.add(it)
        }

        // action
        target.getMotionValues()

        // assert
        assertThat(stateList).isNotEmpty()
        assertThat(stateList).hasSize(2)
        assertThat(stateList[0]).isInstanceOf(MotionValuesState.LOADING::class.java)
        assertThat(stateList[1]).isInstanceOf(MotionValuesState.LOADING::class.java)
    }

    @Test
    fun `getMotionValues server call returns success`() = runBlocking {
        val stateList = mutableListOf<MotionValuesState>()
        target.motionValuesLiveData.observeForever {
            stateList.add(it)
        }

        // action
        target.getMotionValues()

        // assert
        assertThat(stateList).isNotEmpty()
        assertThat(stateList).hasSize(2)
        assertThat(stateList[0]).isInstanceOf(MotionValuesState.LOADING::class.java)
        assertThat(stateList[1]).isInstanceOf(MotionValuesState.LOADING::class.java)
    }
}