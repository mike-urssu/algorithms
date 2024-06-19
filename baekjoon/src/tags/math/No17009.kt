package tags.math

/**
 * https://www.acmicpc.net/problem/17009
 */
fun main() {
    val apples = IntArray(3) { readln().toInt() }
    val bananas = IntArray(3) { readln().toInt() }

    val scoreA = getScore(apples)
    val scoreB = getScore(bananas)
    val winner = if (scoreA > scoreB) {
        "A"
    } else if (scoreA == scoreB) {
        "T"
    } else {
        "B"
    }
    println(winner)
}

private fun getScore(scores: IntArray) =
    scores[0] * 3 + scores[1] * 2 + scores[2]
