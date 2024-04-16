package tags.bruteforcing

/**
 * https://www.acmicpc.net/problem/2615
 */
private lateinit var graph: Array<IntArray>

fun main() {
    graph = Array(19) { readln().split(" ").map { it.toInt() }.toIntArray() }

    for (j in 0 until 19) {
        for (i in 0 until 19) {
            if (graph[i][j] == 1) {
                for (k in 0 until 8) {
                    if (isValid(1, i, j, k)) {
                        println("1")
                        println("${i + 1} ${j + 1}")
                        return
                    }
                }
            } else if (graph[i][j] == 2) {
                for (k in 0 until 8) {
                    if (isValid(2, i, j, k)) {
                        println("2")
                        println("${i + 1} ${j + 1}")
                        return
                    }
                }
            }
        }
    }

    println(0)
}

private val dx = intArrayOf(-1, -1, 0, 1, 1, 1, 0, -1)
private val dy = intArrayOf(0, -1, -1, -1, 0, 1, 1, 1)

private fun isValid(color: Int, x: Int, y: Int, k: Int): Boolean {
    if (!isInBoundary(x + dx[k] * 4, y + dy[k] * 4)) {
        return false
    }

    if ((1..4).any { i -> graph[x + dx[k] * i][y + dy[k] * i] != color }) {
        return false
    }

    if (isInBoundary(x + dx[k] * 5, y + dy[k] * 5) && graph[x + dx[k] * 5][y + dy[k] * 5] == color) {
        return false
    }

    if (isInBoundary(x - dx[k], y - dy[k]) && graph[x - dx[k]][y - dy[k]] == color) {
        return false
    }

    return true
}

private fun isInBoundary(x: Int, y: Int) =
    x in 0 until 19 && y in 0 until 19
