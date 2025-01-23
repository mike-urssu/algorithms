package tags.math

/**
 * https://www.acmicpc.net/problem/5533
 */
fun main() {
    val n = readln().toInt()
    val scores = Array(n) { readln().split(" ").map { it.toInt() }.toIntArray() }

    val totalScores = IntArray(n)
    (0 until 3).forEach { j ->
        (0 until n).forEach { i ->
            if (isUnique(n, scores, i, j)) {
                totalScores[i] += scores[i][j]
            }
        }
    }
    totalScores.forEach { println(it) }
}

private fun isUnique(n: Int, scores: Array<IntArray>, i: Int, j: Int): Boolean {
    for (i2 in 0 until n) {
        if (i != i2 && scores[i][j] == scores[i2][j]) {
            return false
        }
    }
    return true
}
