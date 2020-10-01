import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.*
import java.util.concurrent.locks.Lock
import java.util.concurrent.locks.ReentrantLock

interface JvmMainApi : CommonMainApi, CommonMainLibApi /* TODO NOW, JvmMainLibApi */ {
    fun locks() = mapOf("l1" to ReentrantLock(), "l2" to ReentrantLock())
    fun thisCanSeeJdk() = WeakHashMap<String, Lock>()
}

expect fun jvmMainExpectation(): String

actual fun commonMainExpectation(): String = "hello"

actual typealias CommonMainExpectedClass = BitSet

fun x() {
    GlobalScope.launch(Dispatchers.IO) { }
}