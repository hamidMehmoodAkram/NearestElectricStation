package com.ahoy.livecoding

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule


@ExperimentalCoroutinesApi
abstract class BaseTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()
    private val dispatcher = TestCoroutineDispatcher()

    @Before
    fun setupDispatchers() {
        Dispatchers.setMain(dispatcher)
    }

    @After
    fun tearDownDispatchers() {
        Dispatchers.resetMain()
    }
}