package tags.bruteforcing

/**
 * https://www.acmicpc.net/problem/16924
 */
import java.io.BufferedWriter
import java.io.OutputStreamWriter

private val writer = BufferedWriter(OutputStreamWriter(System.out))
private var n = 0
private var m = 0
private lateinit var graph: Array<CharArray>
private lateinit var isVisited: Array<BooleanArray>
private val crosses = mutableListOf<Triple<Int, Int, Int>>()

fun main() {
    val input = readln().split(" ").map { it.toInt() }
    n = input[0]
    m = input[1]
    graph = Array(n) { readln().toCharArray() }
    isVisited = Array(n) { BooleanArray(m) }

    for (i in 1 until n - 1) {
        for (j in 1 until m - 1) {
            if (graph[i][j] == '*') {
                var s = 0
                while (isValid(i, j, s + 1)) {
                    s++
                }
                if (s != 0) {
                    visit(i, j, s)
                }
            }
        }
    }

    if (isInvalid()) {
        writer.write("-1")
    } else {
        writer.write("${crosses.size}\n")
        crosses.forEach { (x, y, s) ->
            writer.write("$x $y $s\n")
        }
    }
    writer.flush()
}

private val dx = intArrayOf(-1, 0, 1, 0)
private val dy = intArrayOf(0, -1, 0, 1)

private fun isValid(x: Int, y: Int, s: Int) =
    (0 until 4).all { k ->
        val nextX = x + dx[k] * s
        val nextY = y + dy[k] * s
        isInBoundary(nextX, nextY) && graph[nextX][nextY] == '*'
    }

private fun isInBoundary(x: Int, y: Int) =
    x in 0 until n && y in 0 until m

private fun visit(x: Int, y: Int, size: Int) {
    crosses.add(Triple(x + 1, y + 1, size))
    isVisited[x][y] = true
    (1..size).forEach { s ->
        (0 until 4).forEach { k ->
            val nextX = x + dx[k] * s
            val nextY = y + dy[k] * s
            isVisited[nextX][nextY] = true
        }
    }
}

private fun isInvalid() =
    (0 until n).any { i ->
        (0 until m).any { j ->
            graph[i][j] == '*' && !isVisited[i][j]
        }
    }
