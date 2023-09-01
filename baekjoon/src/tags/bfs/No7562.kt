package tags.bfs

/**
 * https://www.acmicpc.net/problem/7562
 */
import java.util.LinkedList
import java.util.Queue

private var l = 0
private lateinit var chess: Array<IntArray>

fun main() {
    val t = readln().toInt()
    repeat(t) {
        l = readln().toInt()
        chess = Array(l) { IntArray(l) }
        val (r1, c1) = readln().split(" ").map { it.toInt() }
        val (r2, c2) = readln().split(" ").map { it.toInt() }
        bfs(r1, c1, r2, c2)
        println(chess[r2][c2])
    }
}

private val dx = intArrayOf(-2, -2, -1, 1, 2, 2, 1, -1)
private val dy = intArrayOf(-1, 1, 2, 2, 1, -1, -2, -2)

private fun bfs(r1: Int, c1: Int, r2: Int, c2: Int) {
    val queue: Queue<Pair<Int, Int>> = LinkedList()
    queue.add(Pair(r1, c1))

    while (queue.isNotEmpty()) {
        val p = queue.poll()
        val x = p.first
        val y = p.second
        if (x == r2 && y == c2) {
            return
        }

        for (i in 0 until 8) {
            val nextX = x + dx[i]
            val nextY = y + dy[i]
            if (isInBoundary(nextX, nextY) && chess[nextX][nextY] == 0) {
                chess[nextX][nextY] = chess[x][y] + 1
                queue.add(Pair(nextX, nextY))
            }
        }
    }
}

private fun isInBoundary(x: Int, y: Int) =
    x in 0 until l && y in 0 until l
