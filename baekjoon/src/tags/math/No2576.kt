package tags.math

/**
 * https://www.acmicpc.net/problem/2576
 */
fun main() {
    val numbers = IntArray(7) { readln().toInt() }
    val odds = numbers.filter { it % 2 == 1 }.sorted()

    if (odds.isEmpty()) {
        println(-1)
    } else {
        println(odds.sum())
        println(odds.first())
    }
}
