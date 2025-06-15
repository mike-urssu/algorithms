package tags.greedy

/**
 * https://www.acmicpc.net/problem/20115
 */
fun main() {
    val n = readln().toInt()
    val numbers = readln().split(" ").map { it.toDouble() }.sorted()
    val sum = (0 until n - 1).sumOf { numbers[it] } / 2.0 + numbers.last()
    println(sum)
}
