package tags.bruteForce

/**
 * https://www.acmicpc.net/problem/2851
 */
import kotlin.math.abs

fun main() {
    val scores = IntArray(10) { readln().toInt() }
    var sum = 0
    var diff = Int.MAX_VALUE

    for (score in scores) {
        val currentScore = 100 - sum - score
        if (abs(currentScore) > abs(diff)) {
            break
        }
        diff = currentScore
        sum += score
    }
    println(sum)
}
