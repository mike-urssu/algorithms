package tags.bfs

/**
 * https://www.acmicpc.net/problem/9328
 */
import java.util.LinkedList
import java.util.Queue

private var h = 0
private var w = 0
private lateinit var graph: Array<CharArray>
private lateinit var isVisited: Array<BooleanArray>
private lateinit var keys: MutableSet<Char>
private var documents = 0

private lateinit var queue: Queue<Pair<Int, Int>>
private lateinit var yetToVisit: MutableSet<Pair<Int, Int>>

fun main() {
    val t = readln().toInt()
    repeat(t) {
        init()
        bfs()
        println(documents)
    }
}

private fun init() {
    val input = readln().split(" ").map { it.toInt() }
    h = input[0]
    w = input[1]
    graph = Array(h) { readln().toCharArray() }
    isVisited = Array(h) { BooleanArray(w) }
    readln().run {
        keys = if (this != "0") {
            this.uppercase().toCharArray().toMutableSet()
        } else {
            mutableSetOf()
        }
    }

    documents = 0
    queue = LinkedList()
    yetToVisit = mutableSetOf()
    setUp()
}

private fun setUp() {
    (0 until h).forEach { i ->
        if (!isVisited[i][0]) {
            when (graph[i][0]) {
                '.' -> {
                    queue.add(i to 0)
                    isVisited[i][0] = true
                }

                '$' -> {
                    queue.add(i to 0)
                    isVisited[i][0] = true
                    documents++
                }

                in 'a'..'z' -> {
                    queue.add(i to 0)
                    isVisited[i][0] = true
                    keys.add(graph[i][0].uppercaseChar())
                }

                in 'A'..'Z' -> {
                    if (keys.contains(graph[i][0])) {
                        queue.add(i to 0)
                        isVisited[i][0] = true
                    } else {
                        yetToVisit.add(i to 0)
                    }
                }
            }
        }

        if (!isVisited[i][w - 1]) {
            when (graph[i][w - 1]) {
                '.' -> {
                    queue.add(i to w - 1)
                    isVisited[i][w - 1] = true
                }

                '$' -> {
                    queue.add(i to w - 1)
                    isVisited[i][w - 1] = true
                    documents++
                }

                in 'a'..'z' -> {
                    queue.add(i to w - 1)
                    isVisited[i][w - 1] = true
                    keys.add(graph[i][w - 1].uppercaseChar())
                }

                in 'A'..'Z' -> {
                    if (keys.contains(graph[i][w - 1])) {
                        queue.add(i to w - 1)
                        isVisited[i][w - 1] = true
                    } else {
                        yetToVisit.add(i to w - 1)
                    }
                }
            }
        }
    }

    (0 until w).forEach { j ->
        if (!isVisited[0][j]) {
            when (graph[0][j]) {
                '.' -> {
                    queue.add(0 to j)
                    isVisited[0][j] = true
                }

                '$' -> {
                    queue.add(0 to j)
                    isVisited[0][j] = true
                    documents++
                }

                in 'a'..'z' -> {
                    queue.add(0 to j)
                    isVisited[0][j] = true
                    keys.add(graph[0][j].uppercaseChar())
                }

                in 'A'..'Z' -> {
                    if (keys.contains(graph[0][j])) {
                        queue.add(0 to j)
                        isVisited[0][j] = true
                    } else {
                        yetToVisit.add(0 to j)
                    }
                }
            }
        }

        if (!isVisited[h - 1][j]) {
            when (graph[h - 1][j]) {
                '.' -> {
                    queue.add(h - 1 to j)
                    isVisited[h - 1][j] = true
                }

                '$' -> {
                    queue.add(h - 1 to j)
                    isVisited[h - 1][j] = true
                    documents++
                }

                in 'a'..'z' -> {
                    queue.add(h - 1 to j)
                    isVisited[h - 1][j] = true
                    keys.add(graph[h - 1][j].uppercaseChar())
                }

                in 'A'..'Z' -> {
                    if (keys.contains(graph[h - 1][j])) {
                        queue.add(h - 1 to j)
                        isVisited[h - 1][j] = true
                    } else {
                        yetToVisit.add(h - 1 to j)
                    }
                }
            }
        }
    }
}

private val dx = intArrayOf(-1, 0, 1, 0)
private val dy = intArrayOf(0, -1, 0, 1)

private fun bfs() {
    while (queue.isNotEmpty()) {
        probe()
        probeYetToVisit()
    }
}

private fun probe() {
    while (queue.isNotEmpty()) {
        val (x, y) = queue.poll()
        for (k in 0 until 4) {
            val nextX = x + dx[k]
            val nextY = y + dy[k]
            if (isInBoundary(nextX, nextY) && !isVisited[nextX][nextY]) {
                if (graph[nextX][nextY] == '.') {
                    queue.add(nextX to nextY)
                    isVisited[nextX][nextY] = true
                } else if (graph[nextX][nextY] in 'a'..'z') {
                    queue.add(nextX to nextY)
                    isVisited[nextX][nextY] = true
                    keys.add(graph[nextX][nextY].uppercaseChar())

                    if (yetToVisit.contains(nextX to nextY)) {
                        queue.add(nextX to nextY)
                        isVisited[nextX][nextY]
                        yetToVisit.remove(nextX to nextY)
                    }
                } else if (graph[nextX][nextY] in 'A'..'Z') {
                    if (keys.contains(graph[nextX][nextY])) {
                        queue.add(nextX to nextY)
                        isVisited[nextX][nextY] = true
                    } else {
                        yetToVisit.add(nextX to nextY)
                    }
                } else if (graph[nextX][nextY] == '$') {
                    queue.add(nextX to nextY)
                    isVisited[nextX][nextY] = true
                    documents++
                }
            }
        }
    }
}

private fun probeYetToVisit() {
    val temp: Queue<Pair<Int, Int>> = LinkedList(yetToVisit)
    yetToVisit = mutableSetOf()
    while (temp.isNotEmpty()) {
        val (x, y) = temp.poll()
        if (keys.contains(graph[x][y])) {
            queue.add(x to y)
            isVisited[x][y] = true
        } else {
            yetToVisit.add(x to y)
        }
    }
}

private fun isInBoundary(x: Int, y: Int) =
    x in 0 until h && y in 0 until w
