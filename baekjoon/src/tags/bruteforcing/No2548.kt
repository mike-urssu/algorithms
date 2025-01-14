package tags.bruteforcing

/**
 * https://www.acmicpc.net/problem/2548
 */
import kotlin.math.abs

fun main() {
    val n = readln().toInt()
    val numbers = readln().split(" ").map { it.toInt() }

    var min = numbers[0]
    var sum = numbers.sumOf { abs(numbers[0] - it) }
    (1 until n).forEach { i ->
        val sum2 = numbers.sumOf { abs(numbers[i] - it) }
        if (sum2 < sum) {
            sum = sum2
            min = numbers[i]
        } else if (sum2 == sum) {
            min = min.coerceAtMost(numbers[i])
        }
    }
    println(min)
}
