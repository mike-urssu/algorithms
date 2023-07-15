package tags.bruteforcing

/**
 * https://www.acmicpc.net/problem/15683
 */
private var n = 0
private var m = 0
private lateinit var graph: Array<CharArray>
private lateinit var cameras: List<Pair<Int, Int>>
private lateinit var combination: Array<Array<Pair<Int, Int>>>
private var min = Int.MAX_VALUE

fun main() {
    val numbers = readln().split(" ").map { it.toInt() }
    n = numbers[0]
    m = numbers[1]
    graph = Array(n) { readln().split(" ").map { it[0] }.toCharArray() }
    cameras = getCameraCoordinates()
    combination = Array(cameras.size) { emptyArray() }

    dfs(0)
    println(min)
}

private fun getCameraCoordinates(): List<Pair<Int, Int>> {
    val cameras = mutableListOf<Pair<Int, Int>>()
    (0 until n).forEach { i ->
        (0 until m).forEach { j ->
            if (graph[i][j] in '1'..'5') {
                cameras.add(Pair(i, j))
            }
        }
    }
    return cameras
}

private val directions = arrayOf(
    arrayOf(emptyArray<Pair<Int, Int>>()),
    arrayOf(
        arrayOf(Pair(-1, 0)),
        arrayOf(Pair(0, 1)),
        arrayOf(Pair(1, 0)),
        arrayOf(Pair(0, -1))
    ),
    arrayOf(
        arrayOf(Pair(-1, 0), Pair(1, 0)),
        arrayOf(Pair(0, -1), Pair(0, 1))
    ),
    arrayOf(
        arrayOf(Pair(-1, 0), Pair(0, 1)),
        arrayOf(Pair(0, 1), Pair(1, 0)),
        arrayOf(Pair(1, 0), Pair(0, -1)),
        arrayOf(Pair(0, -1), Pair(-1, 0))
    ),
    arrayOf(
        arrayOf(Pair(-1, 0), Pair(0, 1), Pair(1, 0)),
        arrayOf(Pair(0, 1), Pair(1, 0), Pair(0, -1)),
        arrayOf(Pair(1, 0), Pair(0, -1), Pair(-1, 0)),
        arrayOf(Pair(0, -1), Pair(-1, 0), Pair(0, 1)),
    ),
    arrayOf(
        arrayOf(Pair(0, -1), Pair(-1, 0), Pair(0, 1), Pair(1, 0))
    )
)

private fun dfs(index: Int) {
    if (index == cameras.size) {
        val copiedGraph = Array(n) { graph[it].copyOf() }
        combination.forEachIndexed { i, directions ->
            val camera = cameras[i]
            setCCTV(copiedGraph, camera.first, camera.second, directions)
        }
        val blindSpots = copiedGraph.sumOf { row -> row.count { it == '0' } }
        min = min.coerceAtMost(blindSpots)
        return
    }

    val coordinates = cameras[index]
    val value = graph[coordinates.first][coordinates.second].digitToInt()
    directions[value].forEach {
        combination[index] = it
        dfs(index + 1)
    }
}

private fun setCCTV(graph: Array<CharArray>, x: Int, y: Int, directions: Array<Pair<Int, Int>>) {
    directions.forEach { direction ->
        val dx = direction.first
        val dy = direction.second
        var nextX = x + dx
        var nextY = y + dy
        while (isInBoundary(nextX, nextY)) {
            if (graph[nextX][nextY] == '6') {
                break
            }
            if (graph[nextX][nextY] == '0') {
                graph[nextX][nextY] = '#'
            }
            nextX += dx
            nextY += dy
        }
    }
}

private fun isInBoundary(x: Int, y: Int) = x in 0 until n && y in 0 until m
