package tags.math

/**
 * https://www.acmicpc.net/problem/17362
 */
fun main() {
    val n = readln().toInt()
    val index = when (n % 8) {
        1 -> 1
        0, 2 -> 2
        3, 7 -> 3
        4, 6 -> 4
        5 -> 5
        else -> -1
    }
    println(index)
}
