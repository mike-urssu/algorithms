package tags.bfs

/**
 * https://www.acmicpc.net/problem/1941
 */
import java.util.LinkedList
import java.util.Queue

private lateinit var graph: Array<CharArray>
private val combination = BooleanArray(25)
private var count = 0

fun main() {
    graph = Array(5) { readln().toCharArray() }
    combination(0, 0)
    println(count)
}

private fun combination(index: Int, depth: Int) {
    if (depth == 7) {
        if (containsAtLeast4S()) {
            if (isConnected()) {
                count++
            }
        }
        return
    }

    (index until 25).forEach { i ->
        if (!combination[i]) {
            combination[i] = true
            combination(i, depth + 1)
            combination[i] = false
        }
    }
}

private fun containsAtLeast4S() =
    (0 until 25)
        .filter { i -> combination[i] }
        .count { i -> graph[i / 5][i % 5] == 'S' } >= 4

private val dx = intArrayOf(-1, 0, 1, 0)
private val dy = intArrayOf(0, -1, 0, 1)

private fun isConnected(): Boolean {
    val queue: Queue<Int> = LinkedList()
    val isVisited = BooleanArray(25)

    val src = (0 until 25).indexOfFirst { i -> combination[i] }
    queue.add(src)
    isVisited[src] = true

    while (queue.isNotEmpty()) {
        val p = queue.poll()
        (0 until 4).forEach { k ->
            val nextX = p / 5 + dx[k]
            val nextY = p % 5 + dy[k]
            if (isInBoundary(nextX, nextY)) {
                val nextP = nextX * 5 + nextY
                if (combination[nextP] && !isVisited[nextP]) {
                    queue.add(nextP)
                    isVisited[nextP] = true
                }
            }
        }
    }

    return isVisited.count { it } == 7
}

private fun isInBoundary(x: Int, y: Int) =
    x in 0 until 5 && y in 0 until 5
