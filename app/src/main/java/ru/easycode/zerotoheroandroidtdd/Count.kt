package ru.easycode.zerotoheroandroidtdd

interface Count {

    fun initial(number: String): UiState
    fun increment(number: String): UiState
    fun decrement(number: String): UiState

    data class Base(val step: Int, val max: Int, val min: Int) : Count {

        init {
            check(step > 0){"step should be positive, but was $step"}
            check(max > 0){"max should be positive, but was $max"}
            check(max > step){"max should be more than step"}
            check(max > min){"max should be more than min"}
        }

        override fun initial(number: String): UiState {
            if (number.toInt() == max) return UiState.Max(number)
            if (number.toInt() == min) return UiState.Min(number)
            return UiState.Base(number)
        }

        override fun increment(number: String): UiState =
            initial(number.toInt().plus(step).toString())


        override fun decrement(number: String): UiState =
            initial(number.toInt().minus(step).toString())
    }
}