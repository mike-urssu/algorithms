package tags.math

/**
 * https://www.acmicpc.net/problem/1405
 */
private var n = 0
private lateinit var possibilities: DoubleArray
private var sum = .0
private val isVisited = Array(29) { BooleanArray(29) }.apply { this[14][14] = true }
private val directions = mutableListOf<Int>()

fun main() {
    val input = readln().split(" ")
    n = input[0].toInt()
    possibilities = input.drop(1).map { it.toDouble() / 100 }.toDoubleArray()

    dfs(0, 14, 14)

    println(sum)
}

private val dx = intArrayOf(0, 0, 1, -1)
private val dy = intArrayOf(1, -1, 0, 0)

private fun dfs(r: Int, x: Int, y: Int) {
    if (n == r) {
        var p = 1.0
        directions.forEach { k ->
            p *= possibilities[k]
        }
        sum += p
        return
    }

    (0 until 4).forEach { k ->
        val nextX = x + dx[k]
        val nextY = y + dy[k]
        if (!isVisited[nextX][nextY]) {
            isVisited[nextX][nextY] = true
            directions.add(k)
            dfs(r + 1, nextX, nextY)
            isVisited[nextX][nextY] = false
            directions.removeLast()
        }
    }
}
