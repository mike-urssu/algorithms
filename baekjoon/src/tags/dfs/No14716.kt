package tags.dfs

/**
 * https://www.acmicpc.net/problem/14716
 */
import java.util.Stack

private var m = 0
private var n = 0
private lateinit var graph: Array<IntArray>
private lateinit var isVisited: Array<BooleanArray>

fun main() {
    val input = readln().split(" ").map { it.toInt() }
    m = input[0]
    n = input[1]
    graph = Array(m) { readln().split(" ").map { -it.toInt() }.toIntArray() }
    isVisited = Array(m) { BooleanArray(n) }

    var cycle = 1
    (0 until m).forEach { i ->
        (0 until n).forEach { j ->
            if (graph[i][j] == -1 && !isVisited[i][j]) {
                val stack = Stack<Pair<Int, Int>>()
                stack.push(i to j)
                while (stack.isNotEmpty()) {
                    val (x, y) = stack.pop()
                    graph[x][y] = cycle
                    isVisited[x][y] = true
                    (0 until 8).forEach { k ->
                        val nextX = x + dx[k]
                        val nextY = y + dy[k]
                        if (isInBoundary(nextX, nextY) && graph[nextX][nextY] == -1 && !isVisited[nextX][nextY]) {
                            stack.push(nextX to nextY)
                        }
                    }
                }
                cycle++
            }
        }
    }
    println(cycle - 1)
}

private val dx = intArrayOf(-1, -1, 0, 1, 1, 1, 0, -1)
private val dy = intArrayOf(0, -1, -1, -1, 0, 1, 1, 1)

private fun isInBoundary(x: Int, y: Int) =
    x in 0 until m && y in 0 until n
