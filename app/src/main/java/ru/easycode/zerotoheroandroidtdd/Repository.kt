package ru.easycode.zerotoheroandroidtdd

import java.net.UnknownHostException

interface Repository {

    suspend fun load(): LoadResult

    class Base(
        private val service: SimpleService,
        private val url: String
    ): Repository {

        override suspend fun load(): LoadResult {
            try {

                val result =  service.fetch(url)
                return LoadResult.Success(data = result)

            } catch (ex : UnknownHostException) {

                return LoadResult.Error(true)

            } catch (ex : Exception) {

                return LoadResult.Error(false)

            }
        }

    }
}