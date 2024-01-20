package tags.math

/**
 * https://www.acmicpc.net/problem/2506
 */
fun main() {
    val n = readln().toInt()
    val scores = readln().split(" ").map { it.toInt() }.toIntArray()
    println(getTotalScore(n, scores))
}

private fun getTotalScore(n: Int, scores: IntArray): Int {
    var totalScore = 0
    var score = 1
    for (i in 0 until n) {
        if (scores[i] == 1) {
            totalScore += score++
        } else {
            score = 1
        }
    }
    return totalScore
}
