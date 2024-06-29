package tags.implementation

/**
 * https://www.acmicpc.net/problem/17837
 */
import kotlin.system.exitProcess

private var n = 0
private lateinit var graph: Array<IntArray>
private lateinit var stack: Array<Array<MutableList<Int>>>
private lateinit var horses: Array<IntArray>

fun main() {
    val input = readln().split(" ").map { it.toInt() }
    n = input[0]
    val k = input[1]
    graph = Array(n + 1) { IntArray(n + 1) }.apply {
        repeat(n) { i ->
            readln().split(" ").map { it.toInt() }.toIntArray().copyInto(this[i + 1], 1)
        }
    }
    stack = Array(n + 1) { Array(n + 1) { mutableListOf() } }
    horses = Array(k + 1) {
        if (it == 0) {
            intArrayOf()
        } else {
            val (x, y, d) = readln().split(" ").map { it.toInt() }
            stack[x][y].add(it)
            intArrayOf(x, y, d)
        }
    }

    for (t in 1..1000) {
        (1..k).forEach { i ->
            val (x, y, d) = horses[i]
            val nextX = x + dx[d]
            val nextY = y + dy[d]

            val isEnded = if (isInBoundary(nextX, nextY)) {
                if (graph[nextX][nextY] == 0) {
                    white(i)
                } else if (graph[nextX][nextY] == 1) {
                    red(i)
                } else {
                    blue(i)
                }
            } else {
                blue(i)
            }

            if (isEnded) {
                println(t)
                exitProcess(0)
            }
        }
    }

    println(-1)
}

private val dx = intArrayOf(0, 0, 0, -1, 1)
private val dy = intArrayOf(0, 1, -1, 0, 0)

private fun white(horseIndex: Int): Boolean {
    val (x, y, d) = horses[horseIndex]
    val nextX = x + dx[d]
    val nextY = y + dy[d]

    val horsesToMove = getHorsesToMove(x, y, horseIndex)
    moveHorses(horsesToMove, x, y, nextX, nextY)
    return stack[nextX][nextY].size >= 4
}

private fun red(horseIndex: Int): Boolean {
    val (x, y, d) = horses[horseIndex]
    val nextX = x + dx[d]
    val nextY = y + dy[d]

    val horsesToMove = getHorsesToMove(x, y, horseIndex)
    moveHorses(horsesToMove.reversed(), x, y, nextX, nextY)
    return stack[nextX][nextY].size >= 4
}

private fun blue(horseIndex: Int): Boolean {
    val (x, y, d) = horses[horseIndex]
    val reversedD = reverseDirection(d)
    horses[horseIndex][2] = reversedD

    val nextX = x + dx[reversedD]
    val nextY = y + dy[reversedD]

    if (!isInBoundary(nextX, nextY) || graph[nextX][nextY] == 2) {
        return false
    }

    val horsesToMove = getHorsesToMove(x, y, horseIndex)
    if (graph[nextX][nextY] == 0) {
        moveHorses(horsesToMove, x, y, nextX, nextY)
    } else if (graph[nextX][nextY] == 1) {
        moveHorses(horsesToMove.reversed(), x, y, nextX, nextY)
    }

    return stack[nextX][nextY].size >= 4
}

private fun getHorsesToMove(x: Int, y: Int, horseIndex: Int): List<Int> {
    val index = stack[x][y].indexOf(horseIndex)
    return (index until stack[x][y].size).map { i -> stack[x][y][i] }
}

private fun moveHorses(horsesToMove: List<Int>, x: Int, y: Int, nextX: Int, nextY: Int) {
    horsesToMove.forEach { i ->
        horses[i][0] = nextX
        horses[i][1] = nextY
    }
    stack[x][y].removeAll(horsesToMove)
    stack[nextX][nextY].addAll(horsesToMove)
}

private fun reverseDirection(d: Int) =
    if (d % 2 == 1) {
        d + 1
    } else {
        d - 1
    }

private fun isInBoundary(x: Int, y: Int) =
    x in 1..n && y in 1..n
