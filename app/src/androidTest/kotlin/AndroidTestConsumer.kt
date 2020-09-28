import org.junit.Assert
import org.junit.Test

class AndroidTestConsumer : JvmMainApi, CommonMainApi, CommonTestApi {

    @Test
    fun testMe() {
        thisCanSeeJdk()
        Assert.assertTrue(2 == 2)
    }

    @Test
    fun fail() {
        Assert.fail("YES")
    }
}