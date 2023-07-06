package tags.bruteforcing

import kotlin.math.abs

/**
 * https://www.acmicpc.net/problem/9663
 */
private lateinit var graph: IntArray
private var count = 0

fun main() {
    val n = readln().toInt()
    graph = IntArray(n)
    nQueen(n, 0)
    println(count)
}

private fun nQueen(n: Int, row: Int) {
    if (row == n) {
        count++
        return
    }

    for (i in 0 until n) {
        graph[row] = i
        if (isValid(row)) {
            nQueen(n, row + 1)
        }
    }
}

private fun isValid(row: Int): Boolean {
    for (i in 0 until row) {    // 절대 같은 행에 있을 수 없음
        if (graph[i] == graph[row] || row - i == abs(graph[row] - graph[i])) { // 같은 열에 있거나 대각선에 있거나
            return false
        }
    }
    return true
}
