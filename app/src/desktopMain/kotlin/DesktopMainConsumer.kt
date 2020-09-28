class DesktopMainConsumer : JvmMainApi, CommonMainApi {
    init {

        val x = thisCanSeeJdk()
        x
    }
}