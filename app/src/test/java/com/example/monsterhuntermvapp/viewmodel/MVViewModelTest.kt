package com.example.monsterhuntermvapp.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.monsterhuntermvapp.model.MotionValuesItem
import com.example.monsterhuntermvapp.rest.MotionValuesRepo
import com.example.monsterhuntermvapp.utils.MotionValuesState
import com.example.monsterhuntermvapp.utils.WeaponType
import com.google.common.truth.Truth.assertThat
import com.google.gson.annotations.SerializedName
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
import kotlinx.coroutines.test.runTest
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
    }

    @Test
    fun `getMotionValues server call returns success`() = runBlocking {

        // assign
        coEvery { mockRepo.getMotionValues(weaponType) } returns mockk {
            every { isSuccessful } returns true
            every { body() } returns listOf(
                mockk {
                    every { damageType } returns "type"
                    every { exhaust } returns 0
                    every { hits } returns listOf(1)
                    every { name } returns "name"
                    every { weaponType } returns "weapon"
                }
            )
        }

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
        assertThat(stateList[1]).isInstanceOf(MotionValuesState.SUCCESS::class.java)
    }

    @Test
    fun `getMotionValues server call not successful`() = runBlocking {

        // assign
        coEvery { mockRepo.getMotionValues(weaponType) } returns mockk {
            every { isSuccessful } returns false
        }

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
        assertThat(stateList[1]).isInstanceOf(MotionValuesState.ERROR::class.java)
    }
}