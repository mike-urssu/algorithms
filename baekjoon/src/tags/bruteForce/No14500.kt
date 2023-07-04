package tags.bruteForce

/**
 * https://www.acmicpc.net/problem/14500
 */
private lateinit var graph: Array<IntArray>
private var n = 0
private var m = 0

fun main() {
    val numbers = readln().split(" ").map { it.toInt() }
    n = numbers[0]
    m = numbers[1]
    graph = Array(n) { readln().split(" ").map { it.toInt() }.toIntArray() }
    val shapes = arrayOf(
        arrayOf(Pair(0, 0), Pair(0, 1), Pair(0, 2), Pair(0, 3)),
        arrayOf(Pair(0, 0), Pair(1, 0), Pair(2, 0), Pair(3, 0)),

        arrayOf(Pair(0, 0), Pair(0, 1), Pair(1, 0), Pair(1, 1)),

        arrayOf(Pair(0, 0), Pair(1, 0), Pair(2, 0), Pair(2, 1)),
        arrayOf(Pair(1, 0), Pair(1, 1), Pair(1, 2), Pair(0, 2)),
        arrayOf(Pair(0, 0), Pair(0, 1), Pair(1, 1), Pair(2, 1)),
        arrayOf(Pair(1, 0), Pair(0, 0), Pair(0, 1), Pair(0, 2)),
        arrayOf(Pair(0, 0), Pair(0, 1), Pair(1, 0), Pair(2, 0)),
        arrayOf(Pair(0, 0), Pair(0, 1), Pair(0, 2), Pair(1, 2)),
        arrayOf(Pair(0, 1), Pair(1, 1), Pair(2, 1), Pair(2, 0)),
        arrayOf(Pair(0, 0), Pair(1, 0), Pair(1, 1), Pair(1, 2)),

        arrayOf(Pair(0, 0), Pair(1, 0), Pair(1, 1), Pair(2, 1)),
        arrayOf(Pair(1, 0), Pair(1, 1), Pair(0, 1), Pair(0, 2)),
        arrayOf(Pair(0, 1), Pair(1, 1), Pair(1, 0), Pair(2, 0)),
        arrayOf(Pair(0, 0), Pair(0, 1), Pair(1, 1), Pair(1, 2)),

        arrayOf(Pair(0, 0), Pair(0, 1), Pair(0, 2), Pair(1, 1)),
        arrayOf(Pair(0, 0), Pair(1, 0), Pair(2, 0), Pair(1, 1)),
        arrayOf(Pair(1, 0), Pair(1, 1), Pair(1, 2), Pair(0, 1)),
        arrayOf(Pair(1, 0), Pair(1, 1), Pair(0, 1), Pair(2, 1))
    )

    var max = 0
    for (i in 0 until n) {
        for (j in 0 until m) {
            for (shape in shapes) {
                if (isInBoundary(i, j, shape)) {
                    max = max.coerceAtLeast(sum(i, j, shape))
                }
            }
        }
    }
    println(max)
}

private fun isInBoundary(row: Int, col: Int, shape: Array<Pair<Int, Int>>): Boolean {
    for (position in shape) {
        if (row + position.first !in 0 until n || col + position.second !in 0 until m) {
            return false
        }
    }
    return true
}

private fun sum(row: Int, col: Int, shape: Array<Pair<Int, Int>>) =
    shape.sumOf { graph[row + it.first][col + it.second] }
