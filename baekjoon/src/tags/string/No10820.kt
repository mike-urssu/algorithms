package tags.string

/**
 * https://www.acmicpc.net/problem/10820
 */
fun main() {
    while (true) {
        val line = readlnOrNull() ?: break
        var lowerCases = 0
        var upperCases = 0
        var digits = 0
        var space = 0
        line.forEach {
            when (it) {
                in 'a'..'z' -> lowerCases++
                in 'A'..'Z' -> upperCases++
                in '0'..'9' -> digits++
                ' ' -> space++
            }
        }
        println("$lowerCases $upperCases $digits $space")
    }
}
