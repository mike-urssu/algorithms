package tags.sorting

/**
 * https://www.acmicpc.net/problem/14729
 */
fun main() {
    val n = readln().toInt()
    val scores = mutableListOf<String>()
    repeat(7) {
        val score = readln()
        scores.add(score)
    }
    var max = scores.maxOf { it.toDouble() }
    repeat(n - 7) {
        val score = readln()
        if (score.toDouble() < max) {
            scores.remove(String.format("%.3f", max))
            scores.add(score)
        }
        max = scores.maxOf { it.toDouble() }
    }
    scores.sortedBy { it.toDouble() }.forEach { println(it) }
}
