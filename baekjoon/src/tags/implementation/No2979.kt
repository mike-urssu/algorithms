package tags.implementation

/**
 * https://www.acmicpc.net/problem/2979
 */
fun main() {
    val times = IntArray(101)
    val (a, b, c) = readln().split(" ").map { it.toInt() }
    repeat(3) {
        val (from, to) = readln().split(" ").map { it.toInt() }
        (from until to).forEach { i -> times[i]++ }
    }

    val cost = (1..100).sumOf { i ->
        when (times[i]) {
            1 -> a
            2 -> b * 2
            3 -> c * 3
            else -> 0
        }
    }
    println(cost)
}
