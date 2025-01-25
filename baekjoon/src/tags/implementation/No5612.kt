package tags.implementation

/**
 * https://www.acmicpc.net/problem/5612
 */
fun main() {
    val n = readln().toInt()
    val m = readln().toInt()
    val cars = IntArray(n + 1)
    cars[0] = m
    (1..n).forEach { i ->
        val (a, b) = readln().split(" ").map { it.toInt() }
        cars[i] = cars[i - 1] + a - b
    }

    val max = if (cars.any { it < 0 }) {
        0
    } else {
        cars.max()
    }
    println(max)
}
