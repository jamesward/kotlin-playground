import kotlin.math.ceil

fun main() {

    fun percentageToProgress(double: Double): String {
        val percentage = double.coerceIn(0.0, 1.0)
        val fill = ceil(percentage * 10).toInt()
        return (0 until fill).joinToString("") { "●" } +
               (fill until 10).joinToString("") { "◯" }
    }

    (0..100 step 5).forEach {
        println(percentageToProgress(it / 100.0) + " $it%")
    }

    require(percentageToProgress(-1.0) == "◯◯◯◯◯◯◯◯◯◯")
    require(percentageToProgress(0.00) == "◯◯◯◯◯◯◯◯◯◯")
    require(percentageToProgress(0.01) == "●◯◯◯◯◯◯◯◯◯")
    require(percentageToProgress(0.10) == "●◯◯◯◯◯◯◯◯◯")
    require(percentageToProgress(0.11) == "●●◯◯◯◯◯◯◯◯")
    require(percentageToProgress(1.00) == "●●●●●●●●●●")
    require(percentageToProgress(2.00) == "●●●●●●●●●●")
}
