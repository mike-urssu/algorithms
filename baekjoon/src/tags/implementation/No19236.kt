package tags.implementation

/**
 * https://www.acmicpc.net/problem/19236
 */
private lateinit var isAlive: BooleanArray
private var max = 0

fun main() {
    val graph = Array(4) { IntArray(4) }
    val fishes = Array(17) { IntArray(3) }
    init(graph, fishes)

    isAlive[graph[0][0]] = false
    val shark = moveShark(graph, fishes, 0, 0)
    moveFishes(graph, fishes, shark)

    moveSharkAndFishes(graph, fishes, shark, max, 0)

    println(max)
}

private fun init(graph: Array<IntArray>, fishes: Array<IntArray>) {
    for (i in 0 until 4) {
        val input = readln().split(" ").map { it.toInt() }
        for (j in 0 until 4) {
            val a = input[j * 2]
            val b = input[j * 2 + 1] - 1
            graph[i][j] = a
            fishes[a] = intArrayOf(i, j, b)
        }
    }

    isAlive = BooleanArray(17) { true }
    isAlive[0] = false

    max = graph[0][0]
}

private val dx = intArrayOf(-1, -1, 0, 1, 1, 1, 0, -1)
private val dy = intArrayOf(0, -1, -1, -1, 0, 1, 1, 1)

private fun moveSharkAndFishes(graph: Array<IntArray>, fishes: Array<IntArray>, shark: IntArray, sum: Int, depth: Int) {
    max = max.coerceAtLeast(sum)

    val (x, y, k) = shark
    for (step in 1..3) {
        val nextX = x + dx[k] * step
        val nextY = y + dy[k] * step
        if (canSharkMove(graph, nextX, nextY)) {
            val clonedGraph = Array(4) { graph[it].copyOf() }
            val clonedFishes = Array(17) { fishes[it].copyOf() }

            isAlive[graph[nextX][nextY]] = false
            val clonedShark = moveShark(clonedGraph, clonedFishes, nextX, nextY)
            moveFishes(clonedGraph, clonedFishes, clonedShark)

            moveSharkAndFishes(clonedGraph, clonedFishes, clonedShark, sum + graph[nextX][nextY], depth + 1)

            isAlive[graph[nextX][nextY]] = true
        }
    }
}

private fun canSharkMove(graph: Array<IntArray>, x: Int, y: Int) =
    isInBoundary(x, y) && graph[x][y] != 0

private fun moveShark(graph: Array<IntArray>, fishes: Array<IntArray>, x: Int, y: Int): IntArray {
    val shark = intArrayOf(x, y, fishes[graph[x][y]][2])
    graph[x][y] = 0
    return shark
}

private fun moveFishes(graph: Array<IntArray>, fishes: Array<IntArray>, shark: IntArray) {
    (1..16).forEach { i ->
        if (isAlive[i]) {
            val (x, y, b) = fishes[i]
            for (k in 0 until 8) {
                val d = (b + k) % 8
                val nextX = x + dx[d]
                val nextY = y + dy[d]
                if (canFishMove(shark, nextX, nextY)) {
                    swap(graph, fishes, x, y, nextX, nextY, d)
                    break
                }
            }
        }
    }
}

private fun canFishMove(shark: IntArray, x: Int, y: Int) =
    isInBoundary(x, y) && !(x == shark[0] && y == shark[1])

private fun isInBoundary(x: Int, y: Int) =
    x in 0 until 4 && y in 0 until 4

private fun swap(graph: Array<IntArray>, fishes: Array<IntArray>, x1: Int, y1: Int, x2: Int, y2: Int, d: Int) {
    fishes[graph[x1][y1]][2] = d

    if (graph[x2][y2] == 0) {
        fishes[graph[x1][y1]][0] = x2
        fishes[graph[x1][y1]][1] = y2
    } else {
        val (x, y) = fishes[graph[x1][y1]]
        fishes[graph[x1][y1]][0] = fishes[graph[x2][y2]][0]
        fishes[graph[x1][y1]][1] = fishes[graph[x2][y2]][1]
        fishes[graph[x2][y2]][0] = x
        fishes[graph[x2][y2]][1] = y
    }

    val temp = graph[x1][y1]
    graph[x1][y1] = graph[x2][y2]
    graph[x2][y2] = temp
}
