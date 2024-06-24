package tags.backtracking

/**
 * https://www.acmicpc.net/problem/18428
 */
import kotlin.system.exitProcess

private var n = 0
private lateinit var graph: Array<CharArray>
private lateinit var teachers: List<Pair<Int, Int>>
private lateinit var students: List<Pair<Int, Int>>

private lateinit var obstacles: BooleanArray

fun main() {
    n = readln().toInt()
    graph = Array(n) { readln().split(" ").map { it[0] }.toCharArray() }

    teachers = find('T')
    students = find('S')
    obstacles = BooleanArray(n * n)

    combination(0, 0)

    println("NO")
}

private fun find(c: Char): List<Pair<Int, Int>> {
    val positions = mutableListOf<Pair<Int, Int>>()
    (0 until n).forEach { i ->
        (0 until n).forEach { j ->
            if (graph[i][j] == c) {
                positions.add(i to j)
            }
        }
    }
    return positions
}

private fun combination(count: Int, index: Int) {
    if (count == 3) {
        canAvoid()
        return
    }

    if (index == n * n) {
        return
    }

    val x = index / n
    val y = index % n

    if (graph[x][y] == 'X') {
        obstacles[index] = true
        combination(count + 1, index + 1)
        obstacles[index] = false
    }
    combination(count, index + 1)
}

private val dx = intArrayOf(-1, 0, 1, 0)
private val dy = intArrayOf(0, -1, 0, 1)

private fun canAvoid() {
    setUpObstacles()

    var canAvoid = true
    teachers.forEach { (x, y) ->
        for (k in 0 until 4) {
            var i = 1
            while (true) {
                val nextX = x + dx[k] * i
                val nextY = y + dy[k] * i

                if (!isInBoundary(nextX, nextY)) {
                    break
                }
                if (graph[nextX][nextY] == 'O') {
                    break
                }

                if (graph[nextX][nextY] == 'S') {
                    canAvoid = false
                }
                i++
            }
        }
    }

    if (canAvoid) {
        println("YES")
        exitProcess(0)
    }

    rollback()
}

private fun setUpObstacles() {
    obstacles.forEachIndexed { i, it ->
        if (it) {
            val x = i / n
            val y = i % n
            graph[x][y] = 'O'
        }
    }
}

private fun rollback() {
    obstacles.forEachIndexed { i, it ->
        if (it) {
            val x = i / n
            val y = i % n
            graph[x][y] = 'X'
        }
    }
}

private fun isInBoundary(x: Int, y: Int) =
    x in 0 until n && y in 0 until n
