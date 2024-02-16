package tags.implementation

/**
 * https://www.acmicpc.net/problem/1205
 */
fun main() {
    val (n, newScore, p) = readln().split(" ").map { it.toInt() }
    val scores = mutableListOf<Int>().apply {
        if (n != 0) {
            this.addAll(readln().split(" ").map { it.toInt() })
        }
        this.add(newScore)
        this.sortDescending()
    }
    println(getRanking(newScore, scores, p))
}

private fun getRanking(newScore: Int, scores: MutableList<Int>, p: Int): Int {
    val index = scores.lastIndexOf(newScore) + 1
    return if (index > p) {
        -1
    } else {
        scores.indexOf(newScore) + 1
    }
}
