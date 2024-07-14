package ru.easycode.zerotoheroandroidtdd

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

interface LiveDataWrapper {

    fun liveData(): LiveData<UiState>
    fun update(value: UiState)

    class Base(
        private var viewLiveData: MutableLiveData<UiState> = MutableLiveData()
    ): LiveDataWrapper {

        override fun liveData(): LiveData<UiState> = viewLiveData

        override fun update(value: UiState) {
            viewLiveData.value = value
        }

    }
}
