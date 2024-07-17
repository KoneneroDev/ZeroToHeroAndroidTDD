package ru.easycode.zerotoheroandroidtdd

interface LoadResult {

    data class Success(
        private val data: SimpleResponse
    ): LoadResult

    data class Error(
        private val noConnection: Boolean
    ): LoadResult

}