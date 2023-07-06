package tags.bruteforcing

/**
 * https://www.acmicpc.net/problem/14502
 */
private var n = 0
private var m = 0

private lateinit var graph: Array<IntArray>
private lateinit var isVisited: Array<BooleanArray>

private var max = 0

fun main() {
    val numbers = readln().split(" ").map { it.toInt() }
    n = numbers[0]
    m = numbers[1]
    graph = Array(n) { readln().split(" ").map { it.toInt() }.toIntArray() }
    isVisited = Array(n) { BooleanArray(m) }

    for (i in 0 until n) {
        for (j in 0 until m) {
            if (graph[i][j] == 0) {
                isVisited[i][j] = true
                graph[i][j] = 1
                setWall(1)
                graph[i][j] = 0
            }
        }
    }

    println(max)
}

private fun setWall(count: Int) {
    if (count == 3) {
        val copiedGraph = deepCopy()
        for (i in 0 until n) {
            for (j in 0 until m) {
                if (copiedGraph[i][j] == 2) {
                    spreadVirus(copiedGraph, i, j)
                }
            }
        }
        val safeAreas = copiedGraph.sumOf { r -> r.count { it == 0 } }
        max = max.coerceAtLeast(safeAreas)
        return
    }

    for (i in 0 until n) {
        for (j in 0 until m) {
            if (!isVisited[i][j] && graph[i][j] == 0) {
                isVisited[i][j] = true
                graph[i][j] = 1
                setWall(count + 1)
                isVisited[i][j] = false
                graph[i][j] = 0
            }
        }
    }
}

private fun deepCopy(): Array<IntArray> {
    val copiedGraph = Array(n) { IntArray(m) }
    for (i in 0 until n) {
        for (j in 0 until m) {
            copiedGraph[i][j] = graph[i][j]
        }
    }
    return copiedGraph
}

private val dx = intArrayOf(0, 1, 0, -1)
private val dy = intArrayOf(-1, 0, 1, 0)

private fun spreadVirus(clone: Array<IntArray>, row: Int, col: Int) {
    clone[row][col] = 2
    for (i in 0 until 4) {
        val nextX = row + dx[i]
        val nextY = col + dy[i]
        if (isInBoundary(nextX, nextY) && clone[nextX][nextY] == 0) {
            spreadVirus(clone, nextX, nextY)
        }
    }
}

private fun isInBoundary(x: Int, y: Int) =
    x in 0 until n && y in 0 until m
