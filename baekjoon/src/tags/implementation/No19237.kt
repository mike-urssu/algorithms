package tags.implementation

/**
 * https://www.acmicpc.net/problem/19237
 */
import kotlin.system.exitProcess

private var n = 0
private var m = 0
private var k = 0
private var alive = 0

private lateinit var graph: Array<IntArray>
private lateinit var directions: IntArray
private lateinit var priorities: Array<Array<IntArray>>

private lateinit var sharks: Array<IntArray>
private lateinit var isAlive: BooleanArray
private lateinit var scents: Array<IntArray>

fun main() {
    init()

    (1..1000).forEach { t ->
        moveSharks()
        if (alive == 1) {
            println(t)
            exitProcess(0)
        }
    }

    println(-1)
}

private fun init() {
    val input = readln().split(" ").map { it.toInt() }
    n = input[0]
    m = input[1]
    k = input[2]
    alive = m

    graph = Array(n) { readln().split(" ").map { it.toInt() }.toIntArray() }
    directions = IntArray(m + 1).apply {
        readln().split(" ").map { it.toInt() }.toIntArray().copyInto(this, 1)
    }
    priorities = Array(m + 1) { Array(5) { IntArray(4) } }
    (1..m).forEach { i ->
        (1..4).forEach { j ->
            priorities[i][j] = readln().split(" ").map { it.toInt() }.toIntArray()
        }
    }

    sharks = Array(m + 1) { IntArray(2) }
    scents = Array(n) { IntArray(n) }
    (0 until n).forEach { i ->
        (0 until n).forEach { j ->
            if (graph[i][j] != 0) {
                val index = graph[i][j]
                sharks[index] = intArrayOf(i, j)
                scents[i][j] = k
            }
        }
    }
    isAlive = BooleanArray(m + 1) { true }
}

private val dx = intArrayOf(0, -1, 1, 0, 0)
private val dy = intArrayOf(0, 0, 0, -1, 1)

private fun moveSharks() {
    val dk = (1..m).map { findDirection(it) }

    (1..m).forEach { i ->
        if (isAlive[i]) {
            val (x, y) = sharks[i]
            val nextX = x + dx[dk[i - 1]]
            val nextY = y + dy[dk[i - 1]]

            val shark = graph[nextX][nextY]
            if (shark != 0) {
                if (shark == i) {
                    graph[nextX][nextY] = i
                    sharks[i][0] = nextX
                    sharks[i][1] = nextY
                } else if (shark < i) {
                    isAlive[i] = false
                    alive--
                    directions[i] = 0
                } else {
                    isAlive[shark] = false
                    alive--
                    graph[nextX][nextY] = i
                    sharks[i][0] = nextX
                    sharks[i][1] = nextY
                }
            } else {
                graph[nextX][nextY] = i
                sharks[i][0] = nextX
                sharks[i][1] = nextY
            }
        }
    }

    removeScents()
    leaveScents()
}

private fun findDirection(index: Int): Int {
    val (x, y) = sharks[index]
    val priority = priorities[index][directions[index]]
    priority.forEach { k ->
        val nextX = x + dx[k]
        val nextY = y + dy[k]
        if (isInBoundary(nextX, nextY) && scents[nextX][nextY] == 0) {
            directions[index] = k
            return k
        }
    }

//    for (k in priority) {
    priority.forEach { k ->
        val nextX = x + dx[k]
        val nextY = y + dy[k]
        if (isInBoundary(nextX, nextY) && graph[nextX][nextY] == index) {
            directions[index] = k
            return k
        }
    }

    return -1
}


private fun isInBoundary(x: Int, y: Int) =
    x in 0 until n && y in 0 until n

private fun removeScents() {
    (0 until n).forEach { i ->
        (0 until n).forEach { j ->
            if (scents[i][j] != 0) {
                scents[i][j]--
                if (scents[i][j] == 0) {
                    graph[i][j] = 0
                }
            }
        }
    }
}

private fun leaveScents() {
    (1..m).forEach { i ->
        if (isAlive[i]) {
            val (x, y) = sharks[i]
            graph[x][y] = i
            scents[x][y] = k
        }
    }
}
