package tags.implementation

/**
 * https://www.acmicpc.net/problem/17780
 */
private var n = 0
private var k = 0
private lateinit var graph: Array<Array<MutableList<Int>>>
private lateinit var colors: Array<IntArray>
private lateinit var positions: MutableList<IntArray>
private lateinit var directions: IntArray
private var isFinished = false

fun main() {
    val input = readln().split(" ").map { it.toInt() }
    n = input[0]
    k = input[1]
    init()

    var turn = -1
    for (t in 1..1000) {
        for (i in 1..k) {
            val (x, y) = positions[i]
            val k = directions[i]
            val nextX = x + dx[k]
            val nextY = y + dy[k]
            if (isInBoundary(nextX, nextY)) {
                when (colors[nextX][nextY]) {
                    0 -> white(i, x, y)
                    1 -> red(i, x, y)
                    2 -> blue(i, x, y)
                }
            } else {
                blue(i, x, y)
            }
        }

        if (isFinished) {
            turn = t
            break
        }
    }

    println(turn)
}

private fun init() {
    graph = Array(n + 1) { Array(n + 1) { mutableListOf() } }
    colors = Array(n + 1) { IntArray(n + 1) }
    (1..n).forEach { i ->
        readln().split(" ").map { it.toInt() }.toIntArray().copyInto(colors[i], 1)
    }

    positions = mutableListOf()
    positions.add(intArrayOf(0, 0))
    directions = IntArray(k + 1)
    (1..k).forEach { i ->
        val (x, y, d) = readln().split(" ").map { it.toInt() }
        graph[x][y].add(i)
        positions.add(intArrayOf(x, y))
        directions[i] = d
    }
}

private val dx = intArrayOf(0, 0, 0, -1, 1)
private val dy = intArrayOf(0, 1, -1, 0, 0)

private fun white(horse: Int, x: Int, y: Int) {
    if (graph[x][y][0] != horse) {
        return
    }

    val horses = graph[x][y].toList()
    moveHorses(horse, x, y, horses)
}

private fun red(horse: Int, x: Int, y: Int) {
    if (graph[x][y][0] != horse) {
        return
    }

    val horses = graph[x][y].reversed()
    moveHorses(horse, x, y, horses)
}

private fun moveHorses(horse: Int, x: Int, y: Int, horses: List<Int>) {
    graph[x][y].clear()

    val k = directions[horse]
    val nextX = x + dx[k]
    val nextY = y + dy[k]

    horses.forEach { h ->
        positions[h][0] = nextX
        positions[h][1] = nextY
    }

    graph[nextX][nextY].addAll(horses)
    if (graph[nextX][nextY].size >= 4) {
        isFinished = true
    }
}

private fun blue(horse: Int, x: Int, y: Int) {
    if (graph[x][y][0] != horse) {
        return
    }

    val k = getNextK(directions[horse])
    directions[horse] = k

    val nextX = x + dx[k]
    val nextY = y + dy[k]
    if (isInBoundary(nextX, nextY)) {
        when (colors[nextX][nextY]) {
            0 -> white(horse, x, y)
            1 -> red(horse, x, y)
        }
    }
}

private fun getNextK(k: Int): Int {
    return if (k % 2 == 0) {
        k - 1
    } else {
        k + 1
    }
}

private fun isInBoundary(x: Int, y: Int) =
    x in 1..n && y in 1..n
