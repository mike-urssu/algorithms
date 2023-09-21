package tags.dijkstra

/**
 * https://www.acmicpc.net/problem/9376
 */
import java.util.PriorityQueue

private var h = 0
private var w = 0
private lateinit var graph: Array<CharArray>

fun main() {
    val t = readln().toInt()
    repeat(t) {
        val input = readln().split(" ").map { it.toInt() }
        h = input[0]
        w = input[1]
        graph = getGraph(h, w)

        val (p1, p2) = getPrisoners()
        val doors = sum(getDoors(Pair(0, 0)), getDoors(p1), getDoors(p2))
        println(doors.minOf { row -> row.min() })
    }
}

private fun getGraph(h: Int, w: Int): Array<CharArray> {
    val graph = Array(h + 2) { CharArray(w + 2) { '.' } }
    for (i in 1..h) {
        readln().toCharArray().copyInto(graph[i], 1)
    }
    return graph
}

private fun getPrisoners(): List<Pair<Int, Int>> {
    val prisoners = mutableListOf<Pair<Int, Int>>()
    for (i in 0 until h + 2) {
        for (j in 0 until w + 2) {
            if (graph[i][j] == '$') {
                prisoners.add(Pair(i, j))
            }
        }
    }
    return prisoners
}

private val dx = intArrayOf(-1, 0, 1, 0)
private val dy = intArrayOf(0, 1, 0, -1)

private fun getDoors(p: Pair<Int, Int>): Array<IntArray> {
    val doors = Array(h + 2) { IntArray(w + 2) { Int.MAX_VALUE } }
    val queue = PriorityQueue<IntArray> { it, other -> it[2].compareTo(other[2]) }

    doors[p.first][p.second] = 0
    queue.add(intArrayOf(p.first, p.second, 0))

    while (queue.isNotEmpty()) {
        val (x, y, door) = queue.poll()
        if (doors[x][y] < door) {
            continue
        }

        for (i in 0 until 4) {
            val nextX = x + dx[i]
            val nextY = y + dy[i]

            if (isInBoundary(nextX, nextY) && graph[nextX][nextY] != '*') {
                if (graph[nextX][nextY] == '.' || graph[nextX][nextY] == '$') {
                    if (doors[nextX][nextY] > door) {
                        doors[nextX][nextY] = door
                        queue.add(intArrayOf(nextX, nextY, door))
                    }
                } else if (graph[nextX][nextY] == '#') {
                    if (doors[nextX][nextY] > door + 1) {
                        doors[nextX][nextY] = door + 1
                        queue.add(intArrayOf(nextX, nextY, door + 1))
                    }
                }
            }
        }
    }

    return doors
}

private fun isInBoundary(x: Int, y: Int) =
    x in 0 until h + 2 && y in 0 until w + 2

private fun sum(doors1: Array<IntArray>, doors2: Array<IntArray>, doors3: Array<IntArray>): Array<IntArray> {
    val doors = Array(h + 2) { IntArray(w + 2) }
    for (i in 0 until h + 2) {
        for (j in 0 until w + 2) {
            doors[i][j] = if (graph[i][j] == '#') {
                doors1[i][j] + doors2[i][j] + doors3[i][j] - 2
            } else {
                doors1[i][j] + doors2[i][j] + doors3[i][j]
            }
        }
    }
    return doors
}
