package tags.implementation

/**
 * https://www.acmicpc.net/problem/23288
 */
import java.util.LinkedList
import java.util.Queue

private var n = 0
private var m = 0
private var k = 0
private lateinit var graph: Array<IntArray>

private var dice = intArrayOf(1, 3, 4, 2, 5, 6)
private var x = 0
private var y = 0
private var score = 0

fun main() {
    val input = readln().split(" ").map { it.toInt() }
    n = input[0]
    m = input[1]
    k = input[2]
    graph = Array(n) { readln().split(" ").map { it.toInt() }.toIntArray() }

    repeat(k) {
        move()
        score += getScore(x, y)
        rotateDirection()
    }
    println(score)
}

private var directions = arrayOf(0 to 1, 1 to 0, 0 to -1, -1 to 0)
private var currentDirection = 0

private fun move() {
    setNextCoords()
    setDice()
}

private fun setNextCoords() {
    var (dx, dy) = directions[currentDirection]
    var nextX = x + dx
    var nextY = y + dy
    if (!isInBoundary(nextX, nextY)) {
        currentDirection = (currentDirection + 2) % 4
        dx = directions[currentDirection].first
        dy = directions[currentDirection].second
        nextX = x + dx
        nextY = y + dy
    }
    x = nextX
    y = nextY
}

private fun setDice() {
    dice = when (currentDirection) {
        0 -> intArrayOf(dice[2], dice[0], dice[5], dice[3], dice[4], dice[1])
        1 -> intArrayOf(dice[3], dice[1], dice[2], dice[5], dice[0], dice[4])
        2 -> intArrayOf(dice[1], dice[5], dice[0], dice[3], dice[4], dice[2])
        else -> intArrayOf(dice[4], dice[1], dice[2], dice[0], dice[5], dice[3])
    }
}

private val dx = intArrayOf(-1, 0, 1, 0)
private val dy = intArrayOf(0, -1, 0, 1)

private fun getScore(i: Int, j: Int): Int {
    var score = 1
    val queue: Queue<Pair<Int, Int>> = LinkedList()
    queue.add(i to j)
    val isVisited = Array(n) { BooleanArray(m) }
    isVisited[i][j] = true
    while (queue.isNotEmpty()) {
        val (x, y) = queue.poll()
        (0 until 4).forEach { k ->
            val nextX = x + dx[k]
            val nextY = y + dy[k]
            if (isInBoundary(nextX, nextY) && !isVisited[nextX][nextY] && graph[nextX][nextY] == graph[i][j]) {
                queue.add(nextX to nextY)
                isVisited[nextX][nextY] = true
                score++
            }
        }
    }
    return graph[i][j] * score
}

private fun isInBoundary(x: Int, y: Int) =
    x in 0 until n && y in 0 until m

private fun rotateDirection() {
    val a = dice[5]
    val b = graph[x][y]
    when (a.compareTo(b)) {
        1 -> currentDirection = (currentDirection + 1) % 4
        -1 -> currentDirection = (currentDirection + 3) % 4
    }
}
