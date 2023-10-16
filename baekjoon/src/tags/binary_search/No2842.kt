package tags.binary_search

/**
 * https://www.acmicpc.net/problem/2842
 */
import java.util.LinkedList
import java.util.Queue

private var n = 0
private lateinit var graph: Array<CharArray>
private lateinit var heights: Array<IntArray>

fun main() {
    n = readln().toInt()
    graph = Array(n) { readln().toCharArray() }
    heights = Array(n) { readln().split(" ").map { it.toInt() }.toIntArray() }
    val src = find('P').first()
    val houses = find('K').size
    println(getMinimumGap(src, houses))
}

private fun find(c: Char): List<Pair<Int, Int>> {
    val pairs = mutableListOf<Pair<Int, Int>>()
    for (i in 0 until n) {
        for (j in 0 until n) {
            if (graph[i][j] == c) {
                pairs.add(Pair(i, j))
            }
        }
    }
    return pairs
}

private fun getMinimumGap(src: Pair<Int, Int>, houses: Int): Int {
    var gap = Int.MAX_VALUE
    val distinctHeights = heights.flatMap { it.toList() }.distinct().sorted()

    for (i in distinctHeights.indices) {
        var low = i
        var high = distinctHeights.lastIndex
        while (low <= high) {
            val mid = (low + high) shr 1
            if (isValid(src, houses, distinctHeights[i]..distinctHeights[mid])) {
                gap = gap.coerceAtMost(distinctHeights[mid] - distinctHeights[i])
                high = mid - 1
            } else {
                low = mid + 1
            }
        }
    }

    return gap
}

private val dx = intArrayOf(-1, -1, 0, 1, 1, 1, 0, -1)
private val dy = intArrayOf(0, 1, 1, 1, 0, -1, -1, -1)

private fun isValid(src: Pair<Int, Int>, houses: Int, range: IntRange): Boolean {
    if (heights[src.first][src.second] !in range) {
        return false
    }

    var count = 0
    val isVisited = Array(n) { BooleanArray(n) }
    val queue: Queue<Pair<Int, Int>> = LinkedList()

    isVisited[src.first][src.second] = true
    queue.add(src)

    while (queue.isNotEmpty()) {
        val (x, y) = queue.poll()
        for (i in 0 until 8) {
            val nextX = x + dx[i]
            val nextY = y + dy[i]
            if (isInBoundary(nextX, nextY) && !isVisited[nextX][nextY] && heights[nextX][nextY] in range) {
                if (graph[nextX][nextY] == 'K') {
                    count++
                }
                isVisited[nextX][nextY] = true
                queue.add(Pair(nextX, nextY))
            }
        }
    }

    return count == houses
}

private fun isInBoundary(x: Int, y: Int) =
    x in 0 until n && y in 0 until n
