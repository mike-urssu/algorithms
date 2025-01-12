package tags.string

/**
 * https://www.acmicpc.net/problem/2204
 */
fun main() {
    while (true) {
        val n = readln().toInt()
        if (n == 0) {
            break
        }
        val words = Array(n) { readln() }.sortedBy { it.lowercase() }
        println(words.first())
    }
}
