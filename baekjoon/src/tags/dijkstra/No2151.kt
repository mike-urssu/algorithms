package tags.dijkstra

/**
 * https://www.acmicpc.net/problem/2151
 */
import java.util.PriorityQueue

private var n = 0
private lateinit var graph: Array<CharArray>
private lateinit var mirrors: Array<IntArray>

fun main() {
    n = readln().toInt()
    graph = Array(n) { readln().toCharArray() }

    val (src, dst) = findDoors(n)
    mirrors = getMirrors(src, dst)
    println(mirrors[dst.first][dst.second])
}

private fun findDoors(n: Int): List<Pair<Int, Int>> {
    val doors = mutableListOf<Pair<Int, Int>>()
    for (i in 0 until n) {
        for (j in 0 until n) {
            if (graph[i][j] == '#') {
                doors.add(Pair(i, j))
            }
        }
    }
    return doors
}

private val dx = intArrayOf(-1, 0, 1, 0)
private val dy = intArrayOf(0, 1, 0, -1)

private fun getMirrors(src: Pair<Int, Int>, dst: Pair<Int, Int>): Array<IntArray> {
    val mirrors = Array(n) { IntArray(n) { Int.MAX_VALUE } }
    val queue = PriorityQueue<Triple<Int, Int, Int>> { it, other -> it.third.compareTo(other.third) }

    mirrors[src.first][src.second] = 0
    for (i in 0 until 4) {
        var nextX = src.first + dx[i]
        var nextY = src.second + dy[i]

        while (isInBoundary(nextX, nextY) && graph[nextX][nextY] != '*') {
            if (graph[nextX][nextY] == '!') {
                mirrors[nextX][nextY] = 1
                queue.add(Triple(nextX, nextY, 1))
            } else if (graph[nextX][nextY] == '#') {
                mirrors[nextX][nextY] = 0
                queue.add(Triple(nextX, nextY, 0))
                break
            }
            nextX += dx[i]
            nextY += dy[i]
        }
    }

    while (queue.isNotEmpty()) {
        val (x, y, mirror) = queue.poll()
        if (mirrors[x][y] < mirror) {
            continue
        }

        if (x == dst.first && y == dst.second) {
            break
        }

        for (i in 0 until 4) {
            var nextX = x + dx[i]
            var nextY = y + dy[i]

            while (isInBoundary(nextX, nextY) && graph[nextX][nextY] != '*') {
                if (graph[nextX][nextY] == '!' && mirrors[nextX][nextY] > mirror + 1) {
                    mirrors[nextX][nextY] = mirror + 1
                    queue.add(Triple(nextX, nextY, mirror + 1))
                } else if (graph[nextX][nextY] == '#' && mirrors[nextX][nextY] > mirror) {
                    mirrors[nextX][nextY] = mirror
                    break
                }
                nextX += dx[i]
                nextY += dy[i]
            }
        }
    }

    return mirrors
}

private fun isInBoundary(x: Int, y: Int) =
    x in 0 until n && y in 0 until n
