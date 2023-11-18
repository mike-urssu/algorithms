package tags.implementation

/**
 * https://www.acmicpc.net/problem/14503
 */
import kotlin.system.exitProcess

private var n = 0
private var m = 0
private lateinit var graph: Array<IntArray>

fun main() {
    val input = readln().split(" ").map { it.toInt() }
    val (r, c, d) = readln().split(" ").map { it.toInt() }

    n = input[0]
    m = input[1]
    graph = getGraph(n)

    cleanRooms(r, c, d)
}

private fun getGraph(n: Int): Array<IntArray> {
    val graph = Array(n) {
        readln().split(" ").map {
            if (it.toInt() == 1) {
                -1
            } else {
                0
            }
        }.toIntArray()
    }
    return graph
}

private val dx = intArrayOf(-1, 0, 1, 0)
private val dy = intArrayOf(0, 1, 0, -1)

private var roomIndex = 1
private fun cleanRooms(x: Int, y: Int, d: Int) {
    graph[x][y] = roomIndex++
    for (i in 0 until 4) {
        val nextX = x + dx[(d + 3 - i) % 4]
        val nextY = y + dy[(d + 3 - i) % 4]
        if (isInBoundary(nextX, nextY) && graph[nextX][nextY] == 0) {
            cleanRooms(nextX, nextY, (d + 3 - i) % 4)
        }
    }

    val dIndex = (d + 2) % 4
    val backX = x + dx[dIndex]
    val backY = y + dy[dIndex]
    if (isInBoundary(backX, backY)) {
        if (graph[backX][backY] != -1) {
            cleanRooms(backX, backY, d)
        } else {
            val cleanRooms = graph.sumOf { row -> row.count { it > 0 } }
            println(cleanRooms)
            exitProcess(0)
        }
    }
}

private fun isInBoundary(x: Int, y: Int) =
    x in 0 until n && y in 0 until m
