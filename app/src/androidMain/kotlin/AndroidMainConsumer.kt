import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class AndroidMainConsumer:  CommonMainApi, CommonMainLibApi, AndroidMainLibApi  {
    init {
        lateinit var x: AppCompatActivity
        GlobalScope.launch {  }
    }
}
