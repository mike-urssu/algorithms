package tags.string

/**
 * https://www.acmicpc.net/problem/9093
 */
fun main() {
    val testCase = readln().toInt()
    repeat(testCase) {
        val reversedWords = readln()
            .split(" ")
            .joinToString(" ") { it.reversed() }
        println(reversedWords)
    }
}
