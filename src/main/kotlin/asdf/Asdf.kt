package asdf

import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.cancel
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.currentCoroutineContext
import kotlinx.coroutines.delay
import kotlinx.coroutines.job
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.util.concurrent.CancellationException
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.coroutineContext

suspend fun asdf(): String {
    return "asdf"
}

suspend fun foo(): String = coroutineScope {
    println(coroutineContext)
    println(Thread.currentThread().name)
    try {
        println(bar())
    }
    catch (e: Exception) {
        println(e)
    }
    println("should not see")
    delay(1000)
    "foo"
}

suspend fun bar(): String = coroutineScope {
    val a1 = async {
        println("a1 started")
        delay(1000)
        println("a1 done")
        //coroutineContext.cancel(CancellationException("a1 cancelled"))
        throw Exception("a1 threw")
    }
    val a2 = async {
        println("a2 started")
        delay(3000)
        println("a2 done")
    }

    a1.await()
    a2.await()

    println("should not get here")
    println(coroutineContext)
    println(Thread.currentThread().name)
    "bar"
}

//suspend fun main() {
//    println(currentCoroutineContext())
//    println(Thread.currentThread().name)
fun main() = runBlocking {
    println(coroutineContext)
    println(Thread.currentThread().name)
    delay(1000)
    println(foo())
    println("should not get here either")
}