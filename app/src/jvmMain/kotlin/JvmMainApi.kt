import java.util.*
import java.util.concurrent.locks.Lock

interface JvmMainApi {
}

fun letsSeeJdk(): WeakHashMap<String, Lock> {
    return WeakHashMap()
}

expect fun hello(): String