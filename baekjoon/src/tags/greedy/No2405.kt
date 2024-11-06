package tags.greedy

/**
 * https://www.acmicpc.net/problem/2405
 */
fun main() {
    val n = readln().toInt()
    val numbers = IntArray(n) { readln().toInt() }.sortedArray()
    var max = (0 until n - 1).maxOf { i -> numbers[i] - 2 * numbers[i + 1] + numbers.last() }
    max = max.coerceAtLeast((1 until n - 1).maxOf { i -> -numbers.first() + 2 * numbers[i] - numbers[i + 1] })
    println(max)
}
