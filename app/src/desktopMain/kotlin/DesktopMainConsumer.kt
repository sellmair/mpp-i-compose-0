class DesktopMainConsumer : JvmMainApi, CommonMainApi, DesktopMainLibApi /*, TODO NOW: Is gone when clean DesktopMainLibApi */ {
    init {
        val x = thisCanSeeJdk()
    }
}