package tags.bfs

/**
 * https://www.acmicpc.net/problem/1194
 */
import java.util.PriorityQueue

private var n = 0
private var m = 0

private lateinit var graph: Array<CharArray>
private lateinit var isVisited: Array<Array<BooleanArray>>

fun main() {
    val input = readln().split(" ").map { it.toInt() }
    n = input[0]
    m = input[1]

    graph = Array(n) { readln().toCharArray() }

    val count = bfs()
    println(count)
}

private fun find(): Pair<Int, Int> {
    var row = 0
    var col = 0
    for (i in 0 until n) {
        for (j in 0 until m) {
            if (graph[i][j] == '0') {
                row = i
                col = j
            }
        }
    }
    return row to col
}

private val dx = intArrayOf(-1, 0, 1, 0)
private val dy = intArrayOf(0, -1, 0, 1)

private fun bfs(): Int {
    isVisited = Array(64) { Array(n) { BooleanArray(m) } }

    val (sx, sy) = find()
    val queue = PriorityQueue<IntArray> { it, other -> it[3].compareTo(other[3]) }

    isVisited[0][sx][sy] = true
    queue.add(intArrayOf(sx, sy, 0, 0))

    while (queue.isNotEmpty()) {
        val (x, y, keys, count) = queue.poll()
        if (graph[x][y] == '1') {
            return count
        }

        for (i in 0 until 4) {
            val nextX = x + dx[i]
            val nextY = y + dy[i]

            if (isInBoundary(nextX, nextY) && !isVisited[keys][nextX][nextY]) {
                if (graph[nextX][nextY] == '#') {
                    continue
                } else if (
                    graph[nextX][nextY] == '.'
                    || graph[nextX][nextY] == '0'
                    || graph[nextX][nextY] == '1'
                ) {
                    isVisited[keys][nextX][nextY] = true
                    queue.add(intArrayOf(nextX, nextY, keys, count + 1))
                } else if (graph[nextX][nextY] in 'A'..'F') {
                    if (keys and (1 shl (graph[nextX][nextY] - 'A')) > 0) {
                        isVisited[keys][nextX][nextY] = true
                        queue.add(intArrayOf(nextX, nextY, keys, count + 1))
                    }
                } else if (graph[nextX][nextY] in 'a'..'f') {
                    val newKeys = keys or (1 shl (graph[nextX][nextY] - 'a'))
                    isVisited[newKeys][nextX][nextY] = true
                    queue.add(intArrayOf(nextX, nextY, newKeys, count + 1))
                }
            }
        }
    }
    return -1
}

private fun isInBoundary(x: Int, y: Int) =
    x in 0 until n && y in 0 until m
