package tags.backtracking

/**
 * https://www.acmicpc.net/problem/1799
 */
private var n = 0
private lateinit var graph: Array<IntArray>
private lateinit var isVisited: Array<BooleanArray>
private var white = 0
private var black = 0

fun main() {
    n = readln().toInt()
    graph = Array(n) { readln().split(" ").map { it.toInt() }.toIntArray() }
    isVisited = Array(n) { BooleanArray(n) }

    whiteDfs(0, 0, 0)
    blackDfs(0, 1, 0)
    println(white + black)
}

private fun whiteDfs(x: Int, y: Int, count: Int) {
    if (x == n) {
        white = white.coerceAtLeast(count)
        return
    }

    val (nextX, nextY) = getNextWhiteCoordinates(x, y)
    if (graph[x][y] == 1 && isValid(x, y)) {
        isVisited[x][y] = true
        whiteDfs(nextX, nextY, count + 1)
        isVisited[x][y] = false
    }
    whiteDfs(nextX, nextY, count)
}

private fun getNextWhiteCoordinates(x: Int, y: Int): Pair<Int, Int> {
    val nextX = if (y + 2 >= n) {
        x + 1
    } else {
        x
    }
    val nextY = if (y + 2 >= n) {
        if (y % 2 == 0) {
            1
        } else {
            0
        }
    } else {
        y + 2
    }
    return nextX to nextY
}

private fun blackDfs(x: Int, y: Int, count: Int) {
    if (x == n) {
        black = black.coerceAtLeast(count)
        return
    }

    val (nextX, nextY) = getNextBlackCoordinates(x, y)
    if (graph[x][y] == 1 && isValid(x, y)) {
        isVisited[x][y] = true
        blackDfs(nextX, nextY, count + 1)
        isVisited[x][y] = false
    }
    blackDfs(nextX, nextY, count)
}

private fun getNextBlackCoordinates(x: Int, y: Int): Pair<Int, Int> {
    val nextX = if (y + 2 >= n) {
        x + 1
    } else {
        x
    }
    val nextY = if (y + 2 >= n) {
        if (y % 2 == 0) {
            1
        } else {
            0
        }
    } else {
        y + 2
    }
    return nextX to nextY
}

private val dx = intArrayOf(-1, 1, 1, -1)
private val dy = intArrayOf(-1, -1, 1, 1)

private fun isValid(x: Int, y: Int): Boolean {
    for (i in 0 until 4) {
        var d = 1
        while (true) {
            val nextX = x + dx[i] * d
            val nextY = y + dy[i] * d
            if (!isInBoundary(nextX, nextY)) {
                break
            }
            if (isVisited[nextX][nextY]) {
                return false
            }
            d++
        }
    }
    return true
}

private fun isInBoundary(x: Int, y: Int) =
    x in 0 until n && y in 0 until n
