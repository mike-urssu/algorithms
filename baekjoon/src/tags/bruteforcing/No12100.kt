package tags.bruteforcing

/**
 * https://www.acmicpc.net/problem/12100
 */
private lateinit var graph: Array<IntArray>
private val movements = Array(5) { "" }
private val directions = arrayOf("up", "right", "down", "left")
private var n = 0
private var max = 0

fun main() {
    n = readln().toInt()
    graph = Array(n) { readln().split(" ").map { it.toInt() }.toIntArray() }
    directions.forEach { setMovements(0, it) }
    println(max)
}

private fun setMovements(index: Int, direction: String) {
    movements[index] = direction
    if (index == 4) {
        val copiedGraph = copyGraph()
        moveBlocks(copiedGraph)
        max = max.coerceAtLeast(findMax(copiedGraph))
        return
    }
    directions.forEach { setMovements(index + 1, it) }
}

private fun copyGraph() = Array(n) { i -> IntArray(n) { j -> graph[i][j] } }

private fun moveBlocks(graph: Array<IntArray>) {
    for (movement in movements) {
        when (movement) {
            "up" -> {
                (0 until n).forEach { j ->
                    mergeUp(graph, j)
                    moveUp(graph, j)
                }
            }

            "right" -> {
                (0 until n).forEach { i ->
                    mergeRight(graph, i)
                    moveRight(graph, i)
                }
            }

            "down" -> {
                (0 until n).forEach { j ->
                    mergeDown(graph, j)
                    moveDown(graph, j)
                }
            }

            "left" -> {
                (0 until n).forEach { i ->
                    mergeLeft(graph, i)
                    moveLeft(graph, i)
                }
            }
        }
    }
}

private fun mergeUp(graph: Array<IntArray>, col: Int) {
    var rowIndex = 0
    for (i in 0 until n) {
        if (i < rowIndex) {
            continue
        }
        for (i2 in i + 1 until n) {
            if (graph[i2][col] == 0) {
                continue
            } else if (graph[i][col] == graph[i2][col]) {
                graph[i][col] += graph[i2][col]
                graph[i2][col] = 0
                rowIndex = i2 + 1
                break
            } else {
                break
            }
        }
    }
}

private fun moveUp(graph: Array<IntArray>, col: Int) {
    for (i in 0 until n) {
        if (graph[i][col] != 0) {
            for (i2 in 0 until i) {
                if (graph[i2][col] == 0) {
                    graph[i2][col] = graph[i][col]
                    graph[i][col] = 0
                    break
                }
            }
        }
    }
}

private fun mergeRight(graph: Array<IntArray>, row: Int) {
    var colIndex = n - 1
    for (j in n - 1 downTo 0) {
        if (j > colIndex) {
            continue
        }
        for (j2 in j - 1 downTo 0) {
            if (graph[row][j2] == 0) {
                continue
            } else if (graph[row][j] == graph[row][j2]) {
                graph[row][j] += graph[row][j2]
                graph[row][j2] = 0
                colIndex = j2 - 1
                break
            } else {
                break
            }
        }
    }
}

private fun moveRight(graph: Array<IntArray>, row: Int) {
    for (j in n - 1 downTo 0) {
        if (graph[row][j] != 0) {
            for (j2 in n - 1 downTo j + 1) {
                if (graph[row][j2] == 0) {
                    graph[row][j2] = graph[row][j]
                    graph[row][j] = 0
                    break
                }
            }
        }
    }
}

private fun mergeDown(graph: Array<IntArray>, col: Int) {
    var rowIndex = n - 1
    for (i in n - 1 downTo 0) {
        if (i > rowIndex) {
            continue
        }
        for (i2 in i - 1 downTo 0) {
            if (graph[i2][col] == 0) {
                continue
            } else if (graph[i][col] == graph[i2][col]) {
                graph[i][col] += graph[i2][col]
                graph[i2][col] = 0
                rowIndex = i2 - 1
                break
            } else {
                break
            }
        }
    }
}

private fun moveDown(graph: Array<IntArray>, col: Int) {
    for (i in n - 1 downTo 0) {
        if (graph[i][col] != 0) {
            for (i2 in n - 1 downTo i + 1) {
                if (graph[i2][col] == 0) {
                    graph[i2][col] = graph[i][col]
                    graph[i][col] = 0
                    break
                }
            }
        }
    }
}

private fun mergeLeft(graph: Array<IntArray>, row: Int) {
    var colIndex = 0
    for (j in 0 until n) {
        if (j < colIndex) {
            continue
        }
        for (j2 in j + 1 until n) {
            if (graph[row][j2] == 0) {
                continue
            } else if (graph[row][j] == graph[row][j2]) {
                graph[row][j] += graph[row][j2]
                graph[row][j2] = 0
                colIndex = j2 + 1
                break
            } else {
                break
            }
        }
    }
}

private fun moveLeft(graph: Array<IntArray>, row: Int) {
    for (j in 0 until n) {
        if (graph[row][j] != 0) {
            for (j2 in 0 until j) {
                if (graph[row][j2] == 0) {
                    graph[row][j2] = graph[row][j]
                    graph[row][j] = 0
                    break
                }
            }
        }
    }
}

private fun findMax(graph: Array<IntArray>) = graph.maxOf { row -> row.max() }
