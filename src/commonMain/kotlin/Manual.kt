import kotlinx.serialization.Serializable

@Serializable
data class Manual(val title: String, val body: String, val path: String = Manual.path) {
    companion object {
        val path = "/1/apropos"
    }
}
