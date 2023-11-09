package tags.implementation

/**
 * https://www.acmicpc.net/problem/14890
 */
private lateinit var graph: Array<IntArray>

fun main() {
    val (n, l) = readln().split(" ").map { it.toInt() }
    graph = Array(n) { readln().split(" ").map { it.toInt() }.toIntArray() }
    println(countBridges(n, l))
}

private fun countBridges(n: Int, l: Int): Int {
    var count = (0 until n).count { i -> isValid(n, graph[i], l) }
    count += (0 until n).count { j ->
        val heights = IntArray(n) { graph[it][j] }
        isValid(n, heights, l)
    }
    return count
}

private fun isValid(n: Int, heights: IntArray, l: Int): Boolean {
    val canBuild = BooleanArray(n) { true }

    var index = 1
    while (index < n) {
        if (heights[index - 1] - heights[index] !in -1..1) {
            return false
        }

        if (heights[index - 1] + 1 == heights[index]) {
            if (index - l < 0) {
                return false
            }

            for (i in index - l until index) {
                if (heights[i] != heights[index] - 1) {
                    return false
                } else if (!canBuild[i]) {
                    return false
                }
                canBuild[i] = false
            }

        } else if (heights[index - 1] == heights[index] + 1) {
            if (index + l - 1 >= n) {
                return false
            }

            for (i in index until index + l) {
                if (heights[i] != heights[index]) {
                    return false
                } else if (!canBuild[i]) {
                    return false
                }
                canBuild[i] = false
            }
        }
        index++
    }
    return true
}
