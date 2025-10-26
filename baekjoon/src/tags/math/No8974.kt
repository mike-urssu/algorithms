package tags.math

/**
 * https://www.acmicpc.net/problem/8974
 */
fun main() {
    val numbers = IntArray(1276)
    var index = 1
    (1..50).forEach { i ->
        repeat(i) {
            numbers[index++] = i
        }
    }
    val (a, b) = readln().split(" ").map { it.toInt() }
    println((a..b).sumOf { numbers[it] })
}
