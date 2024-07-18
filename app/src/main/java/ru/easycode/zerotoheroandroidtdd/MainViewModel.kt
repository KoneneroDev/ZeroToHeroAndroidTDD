package ru.easycode.zerotoheroandroidtdd

class MainViewModel(
    private val liveData: LiveDataW.Base
) {

    fun liveData() = liveData.liveData()

    fun save(bundleWrapper: BundleWrapper.Save) {
        bundleWrapper.save(liveData.get())
    }

    fun restore(bundleWrapper: BundleWrapper.Restore) {
        bundleWrapper.restore()
    }

    fun update(uiState: UiState) {
        liveData.save(uiState)
    }
}