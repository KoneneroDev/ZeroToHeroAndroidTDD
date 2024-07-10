package ru.easycode.zerotoheroandroidtdd

interface Count {

    fun increment(number : String) : UiState

    class Base(private var step : Int, private var max : Int): Count {

        init {
            check(max > 0){"max should be positive, but was $max"}
            check(step < max){"max should be more than step"}
            check(step > 0){"step should be positive, but was $step"}
        }

        override fun increment(number: String): UiState {
            val result = number.toInt().plus(step)
            return if (result.plus(step) > max)
                        UiState.Max(result.toString())
                    else
                        UiState.Base(result.toString())
        }

    }

}
