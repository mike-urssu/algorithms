package tags.bfs

/**
 * https://www.acmicpc.net/problem/4991
 */
import java.util.PriorityQueue

private val writer = System.out.bufferedWriter()

private var w = 0
private var h = 0
private lateinit var graph: Array<CharArray>

private lateinit var rooms: List<Pair<Int, Int>>
private lateinit var distances: Array<IntArray>

private lateinit var combination: IntArray
private lateinit var isVisited: BooleanArray

private var min = 1_000_000

fun main() {
    while (true) {
        val input = readln().split(" ").map { it.toInt() }
        w = input[0]
        h = input[1]
        if (w == 0 && h == 0) {
            break
        }

        min = 1_000_000
        graph = Array(h) { readln().toCharArray() }
        rooms = mutableListOf<Pair<Int, Int>>().apply {
            this.addAll(find('o'))
            this.addAll(find('*'))
        }

        if (rooms.size == 1) {
            writer.write("0\n")
            continue
        }

        distances = getDistances()

        combination = IntArray(rooms.size)
        isVisited = BooleanArray(rooms.size)
        combination[0] = 0
        isVisited[0] = true
        (1 until rooms.size).forEach { i ->
            isVisited[i] = true
            combination[1] = i
            combination(2)
            isVisited[i] = false
        }

        if (min == 1_000_000) {
            min = -1
        }
        writer.write("$min\n")
    }
    writer.flush()
}

private fun find(c: Char): List<Pair<Int, Int>> {
    val list = mutableListOf<Pair<Int, Int>>()
    (0 until h).forEach { i ->
        (0 until w).forEach { j ->
            if (graph[i][j] == c) {
                list.add(i to j)
            }
        }
    }
    return list
}

private fun getDistances(): Array<IntArray> {
    val distances = Array(rooms.size) { IntArray(rooms.size) { Int.MAX_VALUE } }
    for (i in rooms.indices) {
        distances[i][i] = 0
        for (j in i + 1 until rooms.size) {
            distances[i][j] = getDistance(rooms[i], rooms[j])
            distances[j][i] = distances[i][j]
        }
    }
    return distances
}

private fun combination(index: Int) {
    if (index == rooms.size) {
        min = min.coerceAtMost(getDistance())
        return
    }

    (1 until rooms.size).forEach { i ->
        if (!isVisited[i]) {
            isVisited[i] = true
            combination[index] = i
            combination(index + 1)
            isVisited[i] = false
        }
    }
}

private fun getDistance(): Int {
    var distance = 0
    (0 until combination.lastIndex).forEach { i ->
        val src = combination[i]
        val dst = combination[i + 1]
        val d = distances[src][dst]
        if (d == Int.MAX_VALUE) {
            return Int.MAX_VALUE
        }
        distance += d
    }
    return distance
}

private val dx = intArrayOf(-1, 0, 1, 0)
private val dy = intArrayOf(0, -1, 0, 1)

private fun getDistance(src: Pair<Int, Int>, dst: Pair<Int, Int>): Int {
    val queue = PriorityQueue<Triple<Int, Int, Int>> { it, other -> it.third.compareTo(other.third) }
    val isVisited = Array(h) { BooleanArray(w) }
    queue.add(Triple(src.first, src.second, 0))
    isVisited[src.first][src.second] = true

    while (queue.isNotEmpty()) {
        val (x, y, d) = queue.poll()
        if (x == dst.first && y == dst.second) {
            return d
        }

        (0 until 4).forEach { k ->
            val nextX = x + dx[k]
            val nextY = y + dy[k]
            if (isInBoundary(nextX, nextY) && !isVisited[nextX][nextY] && graph[nextX][nextY] != 'x') {
                isVisited[nextX][nextY] = true
                queue.add(Triple(nextX, nextY, d + 1))
            }
        }
    }

    return Int.MAX_VALUE
}

private fun isInBoundary(x: Int, y: Int) =
    x in 0 until h && y in 0 until w
