package tags.implementation

/**
 * https://www.acmicpc.net/problem/10810
 */
fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val baskets = IntArray(n)
    repeat(m) {
        val (i, j, k) = readln().split(" ").map { it.toInt() }
        (i - 1 until j).forEach { baskets[it] = k }
    }
    println(baskets.joinToString(" "))
}
