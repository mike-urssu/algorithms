package tags.bruteforcing

/**
 * https://www.acmicpc.net/problem/15661
 */
import kotlin.math.abs

private var n = 0
private lateinit var graph: Array<IntArray>
private lateinit var link: IntArray
private var sum = 0
private var min = Int.MAX_VALUE

fun main() {
    n = readln().toInt()
    graph = Array(n) { readln().split(" ").map { it.toInt() }.toIntArray() }
    sum = graph.sumOf { it.sum() }

    (1 until n).forEach { i ->
        link = IntArray(i)
        (0 until n).forEach { j -> combination(n, i, 0, j) }
    }

    println(min)
}

private fun combination(n: Int, r: Int, cIndex: Int, nIndex: Int) {
    link[cIndex] = nIndex
    if (cIndex == r - 1) {
        val stark = getStark(n)
        min = min.coerceAtMost(abs(sum(link) - sum(stark)))
        return
    }

    (nIndex + 1 until n).forEach { combination(n, r, cIndex + 1, it) }
}

private fun getStark(n: Int) =
    (0 until n).filter { it !in link }.toIntArray()

private fun sum(numbers: IntArray): Int {
    var sum = 0
    for (i in numbers) {
        for (j in numbers) {
            sum += graph[i][j]
        }
    }
    return sum
}
