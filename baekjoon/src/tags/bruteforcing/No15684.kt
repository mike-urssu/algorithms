package tags.bruteforcing

/**
 * https://www.acmicpc.net/problem/15684
 */
import kotlin.system.exitProcess

private var n = 0
private var h = 0
private lateinit var graph: Array<BooleanArray>

fun main() {
    val numbers = readln().split(" ").map { it.toInt() }
    n = numbers[0]
    val m = numbers[1]
    h = numbers[2]
    graph = Array(h + 1) { BooleanArray(n + 1) }
    repeat(m) {
        val (a, b) = readln().split(" ").map { it.toInt() }
        graph[a][b] = true
    }

    (0..3).forEach { i -> drawLines(1, i, 0) }
    println(-1)
}

private fun drawLines(row: Int, linesToDraw: Int, addedLines: Int) {
    if (linesToDraw == addedLines) {
        if (isValid()) {
            println(linesToDraw)
            exitProcess(0)
        }
        return
    }

    (row..h).forEach { i ->
        for (j in 1 until n) {
            if (graph[i][j - 1] || graph[i][j] || graph[i][j + 1]) {
                continue
            }
            graph[i][j] = true
            drawLines(i, linesToDraw, addedLines + 1)
            graph[i][j] = false
        }
    }
}

private fun isValid(): Boolean {
    for (j in 1..n) {
        var row = 1
        var col = j
        while (row <= h) {
            if (graph[row][col]) {
                col++
            } else if (graph[row][col - 1]) {
                col--
            }
            row++
        }
        if (col != j) {
            return false
        }
    }
    return true
}
