package ru.easycode.zerotoheroandroidtdd

import androidx.lifecycle.LiveData

interface LiveDataWrapper {

    fun save(bundleWrapper: BundleWrapper.Save)

    fun update(value: UiState)

    fun liveData(): LiveData<UiState>

    class Base: LiveDataWrapper {

        private val viewLiveData = SingleLiveEvent<UiState>()

        override fun save(bundleWrapper: BundleWrapper.Save) {
            viewLiveData.value?.let {
                bundleWrapper.save(it)
            }
        }

        override fun update(value: UiState) {
            viewLiveData.value = value
        }

        override fun liveData(): LiveData<UiState> = viewLiveData

    }
}