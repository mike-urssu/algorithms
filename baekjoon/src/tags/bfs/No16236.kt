package tags.bfs

/**
 * https://www.acmicpc.net/problem/16236
 */
import java.util.LinkedList
import java.util.Queue

private var n = 0
private lateinit var graph: Array<IntArray>
private var size = 2
private var prey = 0

fun main() {
    n = readln().toInt()
    graph = Array(n) { readln().split(" ").map { it.toInt() }.toIntArray() }
    var second = 0

    var (row, col) = findSrcPoint()
    graph[row][col] = 0

    while (true) {
        val distances = getDistances(row, col)
        val shortestPoint = getShortestPoint(distances)
        if (shortestPoint.isEmpty()) {
            break
        }
        val (x, y) = shortestPoint
        removePrey(x, y)
        second += distances[x][y]

        row = x
        col = y
    }

    println(second)
}

private fun findSrcPoint(): List<Int> {
    for (i in 0 until n) {
        for (j in 0 until n) {
            if (graph[i][j] == 9) {
                return listOf(i, j)
            }
        }
    }
    return emptyList()
}

private val dx = intArrayOf(-1, 0, 1, 0)
private val dy = intArrayOf(0, 1, 0, -1)

private fun getDistances(row: Int, col: Int): Array<IntArray> {
    val distances = Array(n) { IntArray(n) }
    val isVisited = Array(n) { BooleanArray(n) }
    val queue: Queue<Pair<Int, Int>> = LinkedList()

    isVisited[row][col] = true
    queue.add(Pair(row, col))

    while (queue.isNotEmpty()) {
        val p = queue.poll()
        val x = p.first
        val y = p.second
        for (i in 0 until 4) {
            val nextX = x + dx[i]
            val nextY = y + dy[i]
            if (isInBoundary(nextX, nextY) && graph[nextX][nextY] <= size && !isVisited[nextX][nextY]) {
                distances[nextX][nextY] = distances[x][y] + 1
                isVisited[nextX][nextY] = true
                queue.add(Pair(nextX, nextY))
            }
        }
    }
    return distances
}

private fun isInBoundary(x: Int, y: Int) =
    x in 0 until n && y in 0 until n

private fun getShortestPoint(distances: Array<IntArray>): List<Int> {
    val points = mutableListOf<Pair<Int, Int>>()
    for (i in 0 until n) {
        for (j in 0 until n) {
            if (distances[i][j] > 0 && graph[i][j] in 1 until size) {
                points.add(Pair(i, j))
            }
        }
    }

    return if (points.isEmpty()) {
        emptyList()
    } else {
        val shortestPoint = points.sortedWith(comparator(distances)).first()
        shortestPoint.toList()
    }
}

private fun comparator(distances: Array<IntArray>): Comparator<Pair<Int, Int>> {
    return Comparator { it, other ->
        val x1 = it.first
        val y1 = it.second
        val x2 = other.first
        val y2 = other.second

        if (distances[x1][y1] == distances[x2][y2]) {
            if (it.first == other.first) {
                it.second.compareTo(other.second)
            } else {
                it.first.compareTo(other.first)
            }
        } else {
            distances[x1][y1].compareTo(distances[x2][y2])
        }
    }
}

private fun removePrey(row: Int, col: Int) {
    graph[row][col] = 0
    prey++
    if (size == prey) {
        size++
        prey = 0
    }
}
