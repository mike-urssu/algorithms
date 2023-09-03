package tags.bfs

/**
 * https://www.acmicpc.net/problem/2573
 */
import java.util.LinkedList
import java.util.Queue

private var n = 0
private var m = 0
private lateinit var graph: Array<IntArray>
private lateinit var isVisited: Array<BooleanArray>

fun main() {
    val input = readln().split(" ").map { it.toInt() }
    n = input[0]
    m = input[1]
    graph = Array(n) { readln().split(" ").map { it.toInt() }.toIntArray() }

    var year = 0
    while (true) {
        val heightsToMelt = getHeightsToMelt()
        melt(heightsToMelt)
        val iceBerg = countIceBerg()
        year++

        if (iceBerg == 0) {
            year = 0
            break
        } else if (iceBerg >= 2) {
            break
        }
    }
    println(year)
}

private val dx = intArrayOf(-1, 0, 1, 0)
private val dy = intArrayOf(0, 1, 0, -1)

private fun getHeightsToMelt(): Array<IntArray> {
    val heightsToMelt = Array(n) { IntArray(m) }
    for (i in 0 until n) {
        for (j in 0 until m) {
            if (graph[i][j] != 0) {
                for (k in 0 until 4) {
                    val nextX = i + dx[k]
                    val nextY = j + dy[k]
                    if (isInBoundary(nextX, nextY) && graph[nextX][nextY] == 0) {
                        heightsToMelt[i][j]++
                    }
                }
            }
        }
    }
    return heightsToMelt
}

private fun melt(heightsToMelt: Array<IntArray>) {
    for (i in 0 until n) {
        for (j in 0 until m) {
            graph[i][j] = maxOf(graph[i][j] - heightsToMelt[i][j], 0)
        }
    }
}

private fun countIceBerg(): Int {
    var iceBerg = 0
    isVisited = Array(n) { BooleanArray(m) }
    for (i in 0 until n) {
        for (j in 0 until m) {
            if (!isVisited[i][j] && graph[i][j] > 0) {
                bfs(i, j)
                iceBerg++
            }
        }
    }
    return iceBerg
}

private fun bfs(row: Int, col: Int) {
    val queue: Queue<Pair<Int, Int>> = LinkedList()

    queue.add(Pair(row, col))
    isVisited[row][col] = true

    while (queue.isNotEmpty()) {
        val p = queue.poll()
        val x = p.first
        val y = p.second
        for (i in 0 until 4) {
            val nextX = x + dx[i]
            val nextY = y + dy[i]
            if (isInBoundary(nextX, nextY) && !isVisited[nextX][nextY] && graph[nextX][nextY] > 0) {
                isVisited[nextX][nextY] = true
                queue.add(Pair(nextX, nextY))
            }
        }
    }
}

private fun isInBoundary(x: Int, y: Int) =
    x in 0 until n && y in 0 until m
