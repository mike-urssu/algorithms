package tags.implementation

/**
 * https://www.acmicpc.net/problem/16935
 */
private var n = 0
private var m = 0
private lateinit var graph: Array<IntArray>

fun main() {
    val input = readln().split(" ").map { it.toInt() }
    n = input[0]
    m = input[1]
    graph = Array(n) { readln().split(" ").map { it.toInt() }.toIntArray() }
    val commands = readln().split(" ").map { it.toInt() }.toIntArray()

    commands.forEach { i ->
        when (i) {
            1 -> flipUpsideDown(n)
            2 -> flipLeftRight(n, m)
            3 -> {
                rotateClockWise(n, m)
                val temp = n
                n = m
                m = temp
            }

            4 -> {
                rotateCounterClockWise(n, m)
                val temp = n
                n = m
                m = temp
            }

            5 -> rotateSectionClockWise(n, m)
            6 -> rotateSectionCounterClockWise(n, m)
        }
    }

    graph.forEach { row -> println(row.joinToString(" ")) }
}

private fun flipUpsideDown(n: Int) {
    (0 until n / 2).forEach { i -> swapRow(i, n - 1 - i) }
}

private fun swapRow(row1: Int, row2: Int) {
    val temp = graph[row1].copyOf()
    graph[row1] = graph[row2]
    graph[row2] = temp
}

private fun flipLeftRight(n: Int, m: Int) {
    (0 until n).forEach { i ->
        (0 until m / 2).forEach { j ->
            swapCol(i, j, m - 1 - j)
        }
    }
}

private fun swapCol(row: Int, col1: Int, col2: Int) {
    val temp = graph[row][col1]
    graph[row][col1] = graph[row][col2]
    graph[row][col2] = temp
}

private fun rotateClockWise(n: Int, m: Int) {
    val rotatedGraph = Array(m) { IntArray(n) }
    (0 until m).forEach { i ->
        (0 until n).forEach { j ->
            rotatedGraph[i][j] = graph[n - 1 - j][i]
        }
    }
    graph = rotatedGraph
}

private fun rotateCounterClockWise(n: Int, m: Int) {
    val rotatedGraph = Array(m) { IntArray(n) }
    (0 until m).forEach { i ->
        (0 until n).forEach { j ->
            rotatedGraph[i][j] = graph[j][m - 1 - i]
        }
    }
    graph = rotatedGraph
}

private fun rotateSectionClockWise(n: Int, m: Int) {
    val temp = Array(n / 2) { i ->
        IntArray(m / 2) { j ->
            graph[i][j]
        }
    }

    (0 until n / 2).forEach { i ->
        (0 until m / 2).forEach { j ->
            graph[i][j] = graph[i + n / 2][j]
        }
    }

    (n / 2 until n).forEach { i ->
        (0 until m / 2).forEach { j ->
            graph[i][j] = graph[i][m / 2 + j]
        }
    }

    (n / 2 until n).forEach { i ->
        (m / 2 until m).forEach { j ->
            graph[i][j] = graph[i - n / 2][j]
        }
    }

    (0 until n / 2).forEach { i ->
        (m / 2 until m).forEach { j ->
            graph[i][j] = temp[i][j - m / 2]
        }
    }
}

private fun rotateSectionCounterClockWise(n: Int, m: Int) {
    val temp = Array(n / 2) { i ->
        IntArray(m / 2) { j ->
            graph[i][j]
        }
    }

    (0 until n / 2).forEach { i ->
        (0 until m / 2).forEach { j ->
            graph[i][j] = graph[i][j + m / 2]
        }
    }

    (0 until n / 2).forEach { i ->
        (m / 2 until m).forEach { j ->
            graph[i][j] = graph[i + n / 2][j]
        }
    }

    (n / 2 until n).forEach { i ->
        (m / 2 until m).forEach { j ->
            graph[i][j] = graph[i][j - m / 2]
        }
    }

    (n / 2 until n).forEach { i ->
        (0 until m / 2).forEach { j ->
            graph[i][j] = temp[i - n / 2][j]
        }
    }
}
