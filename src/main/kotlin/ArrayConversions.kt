import java.time.OffsetDateTime
import java.util.stream.IntStream

fun needArray(a: Array<String>) {
    a.forEach(::println)
}


fun <T> f(l: List<T>, timestamp: T.() -> OffsetDateTime): OffsetDateTime = run {
    l.first().timestamp()
}

fun main() {
    f(listOf("asdf")) {
        println(this)
        OffsetDateTime.now()
    }

    /*
    val al: ArrayList<String> = arrayListOf("foo", "bar")
    needArray(al.toTypedArray())

    val nums = listOf(77,85,84,65,66,73,76,73,84,89,0,83,85,67,75,83,1)
    val chars = nums.dropLast(1).map { (it + 32).toChar() }.toCharArray()
    println(String(chars))
     */
}
