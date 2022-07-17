package sharedmutable

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.asCoroutineDispatcher
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import java.util.concurrent.Executors

var i = 0
var j = 0

suspend fun incDec(): Unit = coroutineScope {
    val a1 = async {
        println("i")
        i++
    }
    val a2 = async {
        println("j")
        j--
    }

    a1.await()
    a2.await()
}

suspend fun obs() {
    withContext(Dispatchers.Default) {
        if (i + j != 0) {
            println("$i != $j")
            throw Exception("woah")
        }
    }
}

fun main(): Unit = run {
    CoroutineScope(Executors.newSingleThreadExecutor().asCoroutineDispatcher()).launch {
        async {
            while (true) {
                println("incDec")
                incDec()
            }
        }

        async {
            while (true) {
                println("obs")
                obs()
            }
        }
    }

}