import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.*
import java.util.concurrent.locks.Lock
import java.util.concurrent.locks.ReentrantLock

interface JvmMainApi: CommonMainApi {
    fun locks() = mapOf("l1" to ReentrantLock(), "l2" to ReentrantLock())
    fun thisCanSeeJdk() = WeakHashMap<String, Lock>()
}

expect fun jvmMainExpectation(): String

fun x() {
    GlobalScope.launch(Dispatchers.IO) {  }
}