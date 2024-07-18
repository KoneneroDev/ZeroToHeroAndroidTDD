package ru.easycode.zerotoheroandroidtdd

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

interface LiveDataW {

    fun save(uiState: UiState)
    fun get(): UiState
    fun liveData(): LiveData<UiState>

    class Base: LiveDataW {
        private val liveData = MutableLiveData<UiState>()

        override fun save(uiState: UiState) {
            liveData.value = uiState
        }

        override fun get(): UiState {
            return liveData.value!!
        }

        override fun liveData(): LiveData<UiState> {
            return liveData
        }
    }
}