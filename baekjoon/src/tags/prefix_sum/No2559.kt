package tags.prefix_sum

/**
 * https://www.acmicpc.net/problem/2559
 */
fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val numbers = readln().split(" ").map { it.toInt() }
    var value = numbers.take(k).sum()
    var max = value
    for (i in 0 until n - k) {
        value = value - numbers[i] + numbers[i + k]
        max = max.coerceAtLeast(value)
    }
    println(max)
}
