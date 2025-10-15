package tags.implementation

/**
 * https://www.acmicpc.net/problem/21866
 */
fun main() {
    val maxScores = intArrayOf(100, 100, 200, 200, 300, 300, 400, 400, 500)
    val scores = readln().split(" ").map { it.toInt() }.toIntArray()
    if ((0 until 9).any { scores[it] > maxScores[it] }) {
        println("hacker")
    } else if (scores.sum() >= 100) {
        println("draw")
    } else {
        println("none")
    }
}
