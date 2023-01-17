fun main() {

    val boos = listOf(false, true)

    val allTrue1 = boos.all { it }

    val allTrue2 = boos.reduce(Boolean::and)

    val allFalse = boos.all { !it }

}
