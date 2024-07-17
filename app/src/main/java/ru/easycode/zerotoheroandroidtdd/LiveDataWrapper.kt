package ru.easycode.zerotoheroandroidtdd

import androidx.lifecycle.LiveData

interface LiveDataWrapper {

    interface Save {
        fun save(bundleWrapper: BundleWrapper.Save)
    }

    interface Update {

        fun update(value: UiState)

    }

    interface Observe {
        fun liveData(): LiveData<UiState>
    }

    interface Mutable: Save, Update, Observe

    object Base: Mutable {

        private val liveData = SingleLiveEvent<UiState>()

        override fun liveData() = liveData

        override fun save(bundleWrapper: BundleWrapper.Save) {
            liveData.value?.let { bundleWrapper.save(it)}
        }

        override fun update(value: UiState) {
            liveData.value = value
        }

    }
}