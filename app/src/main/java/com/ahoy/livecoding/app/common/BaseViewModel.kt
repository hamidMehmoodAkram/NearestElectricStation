package com.ahoy.livecoding.app.common

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ahoy.livecoding.home.models.UIState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

abstract class BaseViewModel<T> : ViewModel() {
    val viewStateLiveData: LiveData<UIState<T>>
        get() = _viewStateLiveData
    private val _viewStateLiveData: MutableLiveData<UIState<T>> by lazy {
        MutableLiveData()
    }

    protected fun launch(
        context: CoroutineContext = EmptyCoroutineContext,
        block: suspend () -> Unit
    ) {
        viewModelScope.launch(context) {
            block()
        }
    }


    protected fun unZipViewStateFlow(
        viewStateFlow: Flow<UIState<T>>,
        onSuccess: (T) -> Unit,
        onError: (String) -> Unit = {},
        onLoading: () -> Unit = {},
    ) {
        launch {
            viewStateFlow.collect { viewState ->
                when (viewState) {
                    is UIState.Success -> onSuccess(viewState.data)
                    is UIState.Error -> onError(viewState.message)
                    is UIState.Loading -> onLoading()
                }
                _viewStateLiveData.value = viewState
            }
        }
    }
}