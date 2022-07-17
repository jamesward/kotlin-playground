import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

data class Foo(val s: String)

fun Foo.asdf(i: Int): String = run {
    "hello, world $i times"
}

val blah: Foo.() -> String = {
    "asdf"
}


fun asdf(f: (Foo) -> String): String {
    return f(Foo("asdf"))
}



fun zxcv(f: Foo.() -> String) {
    Foo("asdf").f()
}

suspend fun foo() = coroutineScope {
    launch {

    }
}

fun main() = runBlocking {
    asdf { foo ->
        foo.s.uppercase()
    }
    zxcv {
        this.s.uppercase()
    }
    foo()
    foo()

    val s: String = Foo("asdf").blah()
    println(s)
}
