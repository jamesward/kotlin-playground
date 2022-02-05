
fun needArray(a: Array<String>) {
    a.forEach(::println)
}

fun main() {
    val al: ArrayList<String> = arrayListOf("foo", "bar")
    needArray(al.toTypedArray())
}
