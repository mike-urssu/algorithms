package tags.bruteforcing

/**
 * https://www.acmicpc.net/problem/10655
 */
import kotlin.math.absoluteValue

fun main() {
    val n = readln().toInt()
    val checkpoints = Array(n) {
        val (x, y) = readln().split(" ").map { it.toInt() }
        x to y
    }
    val distances = (0 until n - 1).map { i -> getDistance(checkpoints[i], checkpoints[i + 1]) }
    val sum = distances.sum()
    val min = (1 until n - 1).minOf { i ->
        sum - distances[i - 1] - distances[i] + getDistance(checkpoints[i - 1], checkpoints[i + 1])
    }
    println(min)
}

private fun getDistance(p1: Pair<Int, Int>, p2: Pair<Int, Int>) =
    (p1.first - p2.first).absoluteValue + (p1.second - p2.second).absoluteValue
