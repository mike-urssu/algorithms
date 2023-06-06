package tags.string

/**
 * https://www.acmicpc.net/problem/12605
 */
fun main() {
    val n = readln().toInt()
    repeat(n) {
        val words = readln().split(" ")
        println("Case #${it + 1}: ${words.reversed().joinToString(" ")}")
    }
}
