package tags.bruteforcing

/**
 * https://www.acmicpc.net/problem/3085
 */
private var n = 0
private lateinit var candies: Array<CharArray>
private var max = 0

fun main() {
    n = readln().toInt()
    candies = Array(n) { readln().toCharArray() }
    for (i in 0 until n) {
        for (j in 0 until n) {
            chooseCandy(i, j)
        }
    }
    println(max)
}

private val dx = intArrayOf(-1, 0, 1, 0)
private val dy = intArrayOf(0, 1, 0, -1)

private fun chooseCandy(x: Int, y: Int) {
    for (i in 0 until 4) {
        val nextX = x + dx[i]
        val nextY = y + dy[i]
        if (isInBoundary(nextX, nextY) && candies[x][y] != candies[nextX][nextY]) {
            switchCandies(x, y, nextX, nextY)
            max = max.coerceAtLeast(countCandies())
            switchCandies(nextX, nextY, x, y)
        }
    }
}

private fun isInBoundary(x: Int, y: Int) =
    x in 0 until n && y in 0 until n

private fun switchCandies(x1: Int, y1: Int, x2: Int, y2: Int) {
    val temp = candies[x1][y1]
    candies[x1][y1] = candies[x2][y2]
    candies[x2][y2] = temp
}

private fun countCandies(): Int {
    var max = 0
    (0 until n).forEach { i ->
        var previousColor = candies[i][0]
        var count = 1
        (1 until n).forEach { j ->
            if (candies[i][j] == previousColor) {
                count++
            } else {
                previousColor = candies[i][j]
                count = 1
            }
            max = max.coerceAtLeast(count)
        }
    }

    (0 until n).forEach { j ->
        var count = 1
        var previousColor = candies[0][j]
        (1 until n).forEach { i ->
            if (candies[i][j] == previousColor) {
                count++
            } else {
                previousColor = candies[i][j]
                count = 1
            }
            max = max.coerceAtLeast(count)
        }
    }
    return max
}
