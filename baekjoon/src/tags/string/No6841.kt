package tags.string

/**
 * https://www.acmicpc.net/problem/6841
 */
fun main() {
    while (true) {
        val s = readln()
        val translation = when (s) {
            "CU" -> "see you"
            ":-)" -> "I’m happy"
            ":-(" -> "I’m unhappy"
            ";-)" -> "wink"
            ":-P" -> "stick out my tongue"
            "(~.~)" -> "sleepy"
            "TA" -> "totally awesome"
            "CCC" -> "Canadian Computing Competition"
            "CUZ" -> "because"
            "TY" -> "thank-you"
            "YW" -> "you’re welcome"
            "TTYL" -> "talk to you later"
            else -> s
        }
        println(translation)

        if (s == "TTYL") {
            break
        }
    }
}
