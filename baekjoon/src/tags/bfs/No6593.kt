package tags.bfs

/**
 * https://www.acmicpc.net/problem/6593
 */
import java.util.LinkedList
import java.util.Queue

private var l = 0
private var r = 0
private var c = 0
private lateinit var graph: Array<Array<CharArray>>
private lateinit var isVisited: Array<Array<BooleanArray>>
private lateinit var src: IntArray
private lateinit var dst: IntArray

fun main() {
    while (true) {
        val input = readln().split(" ").map { it.toInt() }
        l = input[0]
        r = input[1]
        c = input[2]
        if (l == 0 && r == 0 && c == 0) {
            break
        }
        graph = getGraph(l, r, c)
        isVisited = Array(l) { Array(r) { BooleanArray(c) } }

        src = find('S')
        dst = find('E')

        val minute = getMinute()
        if (minute == 0) {
            println("Trapped!")
        } else {
            println("Escaped in $minute minute(s).")
        }
    }
}

private fun getGraph(l: Int, r: Int, c: Int): Array<Array<CharArray>> {
    val graph = Array(l) { Array(r) { CharArray(c) } }
    (0 until l).forEach { i ->
        graph[i] = Array(r) { readln().toCharArray() }
        readln()
    }
    return graph
}

private fun find(char: Char): IntArray {
    var x = 0
    var y = 0
    var z = 0
    (0 until l).forEach { i ->
        (0 until r).forEach { j ->
            (0 until c).forEach { k ->
                if (graph[i][j][k] == char) {
                    x = i
                    y = j
                    z = k
                }
            }
        }
    }
    return intArrayOf(x, y, z)
}

private val dx = intArrayOf(-1, 0, 0, 0, 0, 1)
private val dy = intArrayOf(0, -1, 0, 1, 0, 0)
private val dz = intArrayOf(0, 0, 1, 0, -1, 0)

private fun getMinute(): Int {
    var minute = 0
    val queue = LinkedList<Pair<IntArray, Int>>() as Queue<Pair<IntArray, Int>>
    isVisited[src[0]][src[1]][src[2]] = true
    queue.add(Pair(src, 0))

    while (queue.isNotEmpty()) {
        val p = queue.poll()
        if (p.first.contentEquals(dst)) {
            minute = p.second
            break
        }

        val (x, y, z) = p.first
        val m = p.second

        for (i in 0 until 6) {
            val nextX = x + dx[i]
            val nextY = y + dy[i]
            val nextZ = z + dz[i]

            if (
                isInBoundary(nextX, nextY, nextZ)
                && !isVisited[nextX][nextY][nextZ]
                && graph[nextX][nextY][nextZ] != '#'
            ) {
                isVisited[nextX][nextY][nextZ] = true
                queue.add(Pair(intArrayOf(nextX, nextY, nextZ), m + 1))
            }
        }
    }

    return minute
}

private fun isInBoundary(x: Int, y: Int, z: Int) =
    x in 0 until l && y in 0 until r && z in 0 until c
