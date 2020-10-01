interface CommonMainApi: CommonMainLibApi {
    fun x() {

    }
}

expect fun commonMainExpectation(): String

expect class CommonMainExpectedClass
