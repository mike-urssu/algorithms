package tags.bfs

/**
 * https://www.acmicpc.net/problem/7569
 */
import java.util.LinkedList
import java.util.Queue

private var m = 0
private var n = 0
private var h = 0
private lateinit var tomatoes: Array<Array<IntArray>>

fun main() {
    val input = readln().split(" ").map { it.toInt() }
    m = input[0]
    n = input[1]
    h = input[2]
    tomatoes = getTomatoes()

    bfs()

    val day = if (tomatoes.any { board -> board.any { row -> row.any { it == 0 } } }) {
        -1
    } else {
        val max = (0 until h).maxOf { i ->
            (0 until n).maxOf { j ->
                (0 until m).maxOf { k ->
                    tomatoes[i][j][k]
                }
            }
        }
        max - 1
    }
    println(day)
}

private fun getTomatoes() =
    Array(h) {
        Array(n) {
            readln().split(" ").map { it.toInt() }.toIntArray()
        }
    }

private val dx = intArrayOf(-1, 0, 0, 0, 0, 1)
private val dy = intArrayOf(0, -1, 0, 1, 0, 0)
private val dz = intArrayOf(0, 0, 1, 0, -1, 0)

private fun bfs() {
    val queue: Queue<Triple<Int, Int, Int>> = LinkedList()
    (0 until h).forEach { i ->
        (0 until n).forEach { j ->
            (0 until m).forEach { k ->
                if (tomatoes[i][j][k] == 1) {
                    queue.add(Triple(i, j, k))
                }
            }
        }
    }

    while (queue.isNotEmpty()) {
        val p = queue.poll()
        val x = p.first
        val y = p.second
        val z = p.third
        for (i in 0 until 6) {
            val nextX = x + dx[i]
            val nextY = y + dy[i]
            val nextZ = z + dz[i]
            if (isInBoundary(nextX, nextY, nextZ) && tomatoes[nextX][nextY][nextZ] == 0) {
                tomatoes[nextX][nextY][nextZ] = tomatoes[x][y][z] + 1
                queue.add(Triple(nextX, nextY, nextZ))
            }
        }
    }
}

private fun isInBoundary(x: Int, y: Int, z: Int) =
    x in 0 until h && y in 0 until n && z in 0 until m
