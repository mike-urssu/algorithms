package tags.implementation

/**
 * https://www.acmicpc.net/problem/2567
 */
private val isVisited = Array(102) { BooleanArray(102) }

fun main() {
    val n = readln().toInt()
    draw(n)
    println(getLength())
}

private fun draw(n: Int) {
    repeat(n) {
        val (y, x) = readln().split(" ").map { it.toInt() }
        (x until x + 10).forEach { i ->
            (y until y + 10).forEach { j ->
                isVisited[i][j] = true
            }
        }
    }
}

private val dx = intArrayOf(-1, 0, 1, 0)
private val dy = intArrayOf(0, -1, 0, 1)

private fun getLength(): Int {
    var length = 0
    for (x in 1..100) {
        for (y in 1..100) {
            if (isVisited[x][y]) {
                length += (0 until 4).count { k ->
                    val nextX = x + dx[k]
                    val nextY = y + dy[k]
                    !isVisited[nextX][nextY]
                }
            }
        }
    }
    return length
}
