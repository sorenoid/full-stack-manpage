import csstype.HtmlAttributes
import kotlinx.browser.document
import react.*
import kotlinx.coroutines.*
import react.dom.html.ReactHTML.body
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.h1
import react.dom.html.ReactHTML.head
import react.dom.html.ReactHTML.li
import react.dom.html.ReactHTML.section
import react.dom.html.ReactHTML.title
import react.dom.html.ReactHTML.ul

private val scope = MainScope()

@JsModule("html-react-parser")
@JsNonModule
external fun htmlReactParser(html: String):String

val App = FC<Props> {
    var manual by useState(emptyList<Manual>())

    useEffectOnce {
        scope.launch {
            manual = listOf(getManualPage())
        }
    }

    manual.forEach { manual ->
        document.title = manual.title

        section {
            +htmlReactParser(html = manual.body)
        }
    }
}