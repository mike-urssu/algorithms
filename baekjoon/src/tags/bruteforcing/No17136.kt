package tags.bruteforcing

/**
 * https://www.acmicpc.net/problem/17136
 */
private lateinit var graph: Array<BooleanArray>
private lateinit var isVisited: Array<BooleanArray>

private val papers = intArrayOf(0, 0, 0, 0, 0, 0)
private var min = 25

fun main() {
    graph = Array(10) { readln().split(" ").map { it.toInt() == 1 }.toBooleanArray() }
    isVisited = Array(10) { BooleanArray(10) }

    dfs(0)

    if (min == 25) {
        println(-1)
    } else {
        println(min)
    }
}

private fun dfs(count: Int) {
    if (min < count) {
        return
    }

    if (isCovered()) {
        min = min.coerceAtMost(papers.sum())
        return
    }

    for (i in 0 until 10) {
        for (j in 0 until 10) {
            if (graph[i][j] && !isVisited[i][j]) {
                for (k in 5 downTo 1) {
                    if (isValid(k, i, j)) {
                        cover(k, i, j)
                        papers[k]++
                        dfs(count + 1)
                        uncover(k, i, j)
                        papers[k]--
                    }
                }
                return
            }
        }
    }
}

private fun isCovered(): Boolean {
    for (i in 0 until 10) {
        for (j in 0 until 10) {
            if (graph[i][j] && !isVisited[i][j]) {
                return false
            }
        }
    }
    return true
}

private fun isValid(size: Int, x: Int, y: Int): Boolean {
    if (papers[size] == 5) {
        return false
    }

    if (!isInBoundary(x + size - 1, y + size - 1)) {
        return false
    }

    return (x until x + size).all { i ->
        (y until y + size).all { j ->
            graph[i][j] && !isVisited[i][j]
        }
    }
}

private fun cover(size: Int, x: Int, y: Int) {
    (x until x + size).forEach { i ->
        (y until y + size).forEach { j ->
            isVisited[i][j] = true
        }
    }
}

private fun uncover(size: Int, x: Int, y: Int) {
    (x until x + size).forEach { i ->
        (y until y + size).forEach { j ->
            isVisited[i][j] = false
        }
    }
}

private fun isInBoundary(x: Int, y: Int) =
    x in 0 until 10 && y in 0 until 10
