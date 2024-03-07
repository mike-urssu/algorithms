package tags.bruteforcing

/**
 * https://www.acmicpc.net/problem/2961
 */
import kotlin.math.abs

private lateinit var tastes: Array<Pair<Int, Int>>
private lateinit var isVisited: BooleanArray
private var gap = Int.MAX_VALUE

fun main() {
    val n = readln().toInt()
    tastes = Array(n) {
        val (s, b) = readln().split(" ").map { it.toInt() }
        s to b
    }
    isVisited = BooleanArray(n)
    dfs(n, 0)
    println(gap)
}


private fun dfs(n: Int, index: Int) {
    if (index == n) {
        if (isVisited.any { it }) {
            val s = (0 until n).filter { isVisited[it] }
                .fold(1) { acc, i -> acc * tastes[i].first }
            val b = (0 until n).filter { isVisited[it] }
                .sumOf { tastes[it].second }
            gap = gap.coerceAtMost(abs(s - b))
        }
        return
    }

    isVisited[index] = false
    dfs(n, index + 1)

    isVisited[index] = true
    dfs(n, index + 1)
}
