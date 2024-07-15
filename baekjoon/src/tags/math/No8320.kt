package tags.math

/**
 * https://www.acmicpc.net/problem/8320
 */
import kotlin.math.sqrt

fun main() {
    val counts = LongArray(10001) { i ->
        val sqrt = sqrt(i.toDouble()).toInt()
        (1..sqrt).count { i % it == 0 }.toLong()
    }
    val prefixSum = counts.runningFold(0, Long::plus).drop(1)

    val n = readln().toInt()
    println(prefixSum[n])
}
