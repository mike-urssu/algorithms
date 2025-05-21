package tags.math

/**
 * https://www.acmicpc.net/problem/5692
 */
fun main() {
    val factorial = intArrayOf(1, 2, 6, 24, 120)
    while (true) {
        val n = readln()
        if (n == "0") {
            break
        }
        val decimal = n.reversed().mapIndexed { i, v -> v.digitToInt() * factorial[i] }.sum()
        println(decimal)
    }
}
