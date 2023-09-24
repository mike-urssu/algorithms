package tags.bfs

/**
 * https://www.acmicpc.net/problem/3055
 */
import java.util.LinkedList
import java.util.PriorityQueue
import java.util.Queue

private var r = 0
private var c = 0
private lateinit var graph: Array<CharArray>

fun main() {
    val input = readln().split(" ").map { it.toInt() }
    r = input[0]
    c = input[1]
    graph = Array(r) { readln().toCharArray() }

    val s = find('S')
    val d = find('D')

    val times = getTimes(s)
    if (times[d.first][d.second] == Int.MAX_VALUE) {
        println("KAKTUS")
    } else {
        println(times[d.first][d.second])
    }
}

private fun find(character: Char): Pair<Int, Int> {
    var row = 0
    var col = 0
    for (i in 0 until r) {
        for (j in 0 until c) {
            if (graph[i][j] == character) {
                row = i
                col = j
            }
        }
    }
    return Pair(row, col)
}

private val dx = intArrayOf(-1, 0, 1, 0)
private val dy = intArrayOf(0, 1, 0, -1)

private fun getTimes(s: Pair<Int, Int>): Array<IntArray> {
    val times = Array(r) { IntArray(c) { Int.MAX_VALUE } }
    val waters = getWaters()
    val queue = PriorityQueue<Triple<Int, Int, Int>> { it, other -> it.third.compareTo(other.third) }

    times[s.first][s.second] = 0
    queue.add(Triple(s.first, s.second, 0))

    while (queue.isNotEmpty()) {
        val (x, y, t1) = queue.poll()
        if (times[x][y] < t1) {
            continue
        }

        for (i in 0 until 4) {
            val nextX = x + dx[i]
            val nextY = y + dy[i]
            if (isInBoundary(nextX, nextY)
                && graph[nextX][nextY] !in charArrayOf('*', 'X')
                && times[nextX][nextY] > times[x][y] + 1
                && waters[nextX][nextY] > times[x][y] + 1
            ) {
                times[nextX][nextY] = times[x][y] + 1
                queue.add(Triple(nextX, nextY, times[nextX][nextY]))
            }
        }
    }

    return times
}

private fun getWaters(): Array<IntArray> {
    val waters = Array(r) { IntArray(c) { Int.MAX_VALUE } }
    val isVisited = Array(r) { BooleanArray(c) }
    val queue: Queue<Pair<Int, Int>> = LinkedList()
    for (i in 0 until r) {
        for (j in 0 until c) {
            if (graph[i][j] == '*') {
                waters[i][j] = 0
                isVisited[i][j] = true
                queue.add(Pair(i, j))
            }
        }
    }

    while (queue.isNotEmpty()) {
        val (x, y) = queue.poll()
        for (i in 0 until 4) {
            val nextX = x + dx[i]
            val nextY = y + dy[i]
            if (isInBoundary(nextX, nextY) && !isVisited[nextX][nextY]) {
                if (graph[nextX][nextY] == '.') {
                    waters[nextX][nextY] = waters[x][y] + 1
                    isVisited[nextX][nextY] = true
                    queue.add(Pair(nextX, nextY))
                } else if (graph[nextX][nextY] == 'D') {
                    waters[nextX][nextY] = Int.MAX_VALUE
                }
            }
        }
    }
    return waters
}

private fun isInBoundary(x: Int, y: Int) =
    x in 0 until r && y in 0 until c
