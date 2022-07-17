import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.count
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf

val a = MutableSharedFlow<String>()

fun goFlow(): Flow<String> = run {
    flow {
        emit("asdf")
        delay(1000)
        emit("zxcv")
    }
}


suspend fun main() {
    val g = goFlow()
    //println(g.count())

    g.collect {
        println(it)
    }
}