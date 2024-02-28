package tags.dfs

/**
 * https://www.acmicpc.net/problem/1388
 */
private lateinit var graph: Array<CharArray>
private lateinit var isVisited: Array<BooleanArray>

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    graph = Array(n) { readln().toCharArray() }
    isVisited = Array(n) { BooleanArray(m) }

    var count = 0
    for (i in 0 until n) {
        for (j in 0 until m) {
            if (!isVisited[i][j]) {
                isVisited[i][j] = true
                if (graph[i][j] == '-') {
                    eraseCol(m, i, j)
                    count++
                } else {
                    eraseRow(n, i, j)
                    count++
                }
            }
        }
    }
    println(count)
}

private fun eraseCol(m: Int, x: Int, y: Int) {
    for (j in y until m) {
        if (graph[x][j] == '-') {
            isVisited[x][j] = true
        } else {
            break
        }
    }
}

private fun eraseRow(n: Int, x: Int, y: Int) {
    for (i in x until n) {
        if (graph[i][y] == '|') {
            isVisited[i][y] = true
        } else {
            break
        }
    }
}
