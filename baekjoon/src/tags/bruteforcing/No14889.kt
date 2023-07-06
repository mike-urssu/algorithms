package tags.bruteforcing

/**
 * https://www.acmicpc.net/problem/14889
 */
import kotlin.math.absoluteValue

private lateinit var graph: Array<IntArray>
private lateinit var isVisited: BooleanArray
private var min = Int.MAX_VALUE

fun main() {
    val n = readln().toInt()
    graph = Array(n) { readln().split(" ").map { it.toInt() }.toIntArray() }
    isVisited = BooleanArray(n)
    divideTeam(n, 0, 0)
    println(min)
}

private fun divideTeam(n: Int, index: Int, count: Int) {
    if (count == n / 2) {
        val startScore = calculateScore(getTeam(true))
        val linkScore = calculateScore(getTeam(false))
        min = min.coerceAtMost((startScore - linkScore).absoluteValue)
        return
    }

    for (i in index until n) {
        if (!isVisited[i]) {
            isVisited[i] = true
            divideTeam(n, i + 1, count + 1)
            isVisited[i] = false
        }
    }
}

private fun getTeam(type: Boolean) =
    isVisited.indices.filter { i -> isVisited[i] == type }.toIntArray()

private fun calculateScore(indices: IntArray): Int {
    var score = 0
    for (i in indices) {
        for (j in indices) {
            if (i != j) {
                score += graph[i][j]
            }
        }
    }
    return score
}
