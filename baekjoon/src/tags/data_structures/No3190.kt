package tags.data_structures

/**
 * https://www.acmicpc.net/problem/3190
 */
private var n = 0
private lateinit var graph: Array<IntArray>
private var seconds = 0

fun main() {
    n = readln().toInt()
    val k = readln().toInt()
    setGraph(n, k)

    val l = readln().toInt()
    val movements = getMovements(l)

    moveSnake(movements)
    println(seconds)
}

private fun setGraph(n: Int, k: Int) {
    graph = Array(n) { IntArray(n) }
    repeat(k) {
        val (x, y) = readln().split(" ").map { it.toInt() - 1 }
        graph[x][y] = 1
    }
    graph[0][0] = 8
}

private fun getMovements(l: Int) =
        Array(l) {
            val (x, c) = readln().split(" ")
            Pair(x.toInt(), c[0])
        }

private fun moveSnake(movements: Array<Pair<Int, Char>>) {
    val snake = ArrayDeque<Pair<Int, Int>>().apply { this.add(Pair(0, 0)) }

    for (movement in movements) {
        while (seconds < movement.first) {
            seconds++

            val head = snake.first()
            val nextX = head.first + dx[directionIndex]
            val nextY = head.second + dy[directionIndex]

            if (!isSnakeMovable(nextX, nextY)) {
                return
            }

            move(snake, nextX, nextY)
        }
        setNextDirection(movement.second)
    }

    while (true) {
        seconds++

        val head = snake.first()
        val nextX = head.first + dx[directionIndex]
        val nextY = head.second + dy[directionIndex]

        if (!isSnakeMovable(nextX, nextY)) {
            return
        }

        move(snake, nextX, nextY)
    }
}

private val dx = intArrayOf(-1, 0, 1, 0)
private val dy = intArrayOf(0, 1, 0, -1)
private var directionIndex = 1

private fun isSnakeMovable(x: Int, y: Int) = x in 0 until n && y in 0 until n && graph[x][y] != 8

private fun move(snake: ArrayDeque<Pair<Int, Int>>, nextX: Int, nextY: Int) {
    snake.addFirst(Pair(nextX, nextY))

    if (graph[nextX][nextY] == 1) {
        graph[nextX][nextY] = 8
    } else {
        graph[nextX][nextY] = 8
        val tail = snake.removeLast()
        graph[tail.first][tail.second] = 0
    }
}

private fun setNextDirection(nextDirection: Char) {
    directionIndex = if (nextDirection == 'L') {
        (directionIndex + 3) % 4
    } else {
        (directionIndex + 1) % 4
    }
}
