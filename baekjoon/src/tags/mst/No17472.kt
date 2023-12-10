package tags.mst

/**
 * https://www.acmicpc.net/problem/17472
 */
import kotlin.math.abs

private var n = 0
private var m = 0
private lateinit var graph: Array<IntArray>
private var group = 1

private lateinit var parents: IntArray

fun main() {
    val input = readln().split(" ").map { it.toInt() }
    n = input[0]
    m = input[1]
    graph = Array(n) { readln().split(" ").map { -it.toInt() }.toIntArray() }
    setGraph()

    val distance = connectBridges()

    if (areConnected()) {
        println(distance)
    } else {
        println(-1)
    }
}

private fun setGraph() {
    (0 until n).forEach { i ->
        (0 until m).forEach { j ->
            if (graph[i][j] == -1) {
                dfs(i, j, group++)
            }
        }
    }
}

private fun areConnected(): Boolean {
    val p1 = find(1)
    return (2 until group).all { p1 == find(it) }
}

private val dx = intArrayOf(-1, 0, 1, 0)
private val dy = intArrayOf(0, 1, 0, -1)

private fun dfs(x: Int, y: Int, group: Int) {
    graph[x][y] = group
    for (i in 0 until 4) {
        val nextX = x + dx[i]
        val nextY = y + dy[i]
        if (isInBoundary(nextX, nextY) && graph[nextX][nextY] == -1) {
            dfs(nextX, nextY, group)
        }
    }
}

private fun isInBoundary(x: Int, y: Int) =
    x in 0 until n && y in 0 until m

private fun connectBridges(): Int {
    parents = IntArray(group) { it }
    var distance = 0
    val distances = getDistances()
    distances.forEach { (src, dst, d) ->
        if (find(src) != find(dst)) {
            union(src, dst)
            distance += d
        }
    }
    return distance
}

private fun getDistances(): List<Triple<Int, Int, Int>> {
    val distances = mutableListOf<Triple<Int, Int, Int>>()
    (0 until n).forEach { i ->
        (0 until m).forEach { j ->
            if (graph[i][j] != 0) {
                addDistances(distances, i, j)
            }
        }
    }
    distances.sortWith { it, other -> it.third.compareTo(other.third) }
    return distances
}

private fun addDistances(distances: MutableList<Triple<Int, Int, Int>>, x: Int, y: Int) {
    for (k in 0 until 4) {
        var nextX = x
        var nextY = y

        while (true) {
            nextX += dx[k]
            nextY += dy[k]

            if (!isInBoundary(nextX, nextY)) {
                break
            } else if (graph[nextX][nextY] == 0) {
                continue
            } else if (graph[nextX][nextY] == graph[x][y]) {
                break
            } else {
                val distance = abs(x + y - nextX - nextY) - 1
                if (distance > 1) {
                    distances.add(Triple(graph[x][y], graph[nextX][nextY], distance))
                }
                break
            }
        }
    }
}

private fun union(a: Int, b: Int) {
    val parentA = find(a)
    val parentB = find(b)
    parents[parentA] = parentB
}

private fun find(n: Int): Int {
    if (parents[n] != n) {
        parents[n] = find(parents[n])
    }
    return parents[n]
}
