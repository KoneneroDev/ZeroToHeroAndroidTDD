package ru.easycode.zerotoheroandroidtdd

import android.os.Bundle

interface BundleWrapper {

    interface Save {
        fun save(uiState: UiState)
    }

    interface Restore {
        fun restore(): UiState
    }

    class Base(private val bundle: Bundle): Save, Restore {

        override fun save(uiState: UiState) {
            bundle.putSerializable(KEY, uiState)
        }

        override fun restore(): UiState {
            return bundle.getSerializable(KEY) as UiState
        }

    }

    companion object {
        private const val KEY = ""
    }
}