package ru.easycode.zerotoheroandroidtdd

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(
    private val liveDataWrapper: LiveDataWrapper.Mutable,
    private val repository: Repository
) {

    private val coroutine = CoroutineScope(Dispatchers.Main.immediate)

    fun liveData() = liveDataWrapper.liveData()

     fun load() {
        liveDataWrapper.update(UiState.ShowProgress)
        coroutine.launch {
            repository.load().show(liveDataWrapper)
        }
    }

    fun save(bundleWrapper: BundleWrapper.Save) {
        liveDataWrapper.liveData().value?.let {
            bundleWrapper.save(it)
        }
    }

    fun restore(bundleWrapper: BundleWrapper.Restore) {
        liveDataWrapper.update(bundleWrapper.restore())
    }

}