fun String.guts(startTag: String, endTag: String): String =
    replaceAfterLast(endTag, "")
        .replaceBefore(startTag, "")
        .replace(endTag, "")
        .replace(startTag, "")

class Html2Json {
    val manuals = mutableListOf<Manual>()

    init {
        val apropos = this::class.java.classLoader.getResource("apropos.1.html")!!.readText()
        val head = apropos.guts("<head>", "</head>")
        val body = apropos.guts("<body>", "</body>")

        val title = head.guts("<title>", "</title>")
        // println("body: $body")
        manuals.add(Manual(title, body, Manual.path))
    }
}