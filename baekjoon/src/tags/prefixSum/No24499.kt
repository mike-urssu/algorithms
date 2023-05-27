package tags.prefixSum

/**
 * https://www.acmicpc.net/problem/24499
 */
fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }
    val numbers = readln().split(" ").map { it.toInt() }
    var max = Int.MIN_VALUE
    var sum = numbers.take(k).sum()
    for (i in numbers.indices) {
        sum = sum - numbers[i] + numbers[(i + k) % n]
        max = max.coerceAtLeast(sum)
    }
    println(max)
}
