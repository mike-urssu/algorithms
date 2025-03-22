package tags.backtracking

/**
 * https://www.acmicpc.net/problem/3980
 */
private lateinit var graph: Array<IntArray>
private lateinit var isVisited: BooleanArray
private var max = 0

fun main() {
    val c = readln().toInt()
    repeat(c) {
        graph = Array(11) { readln().split(" ").map { it.toInt() }.toIntArray() }
        isVisited = BooleanArray(11)
        max = 0
        (0 until 11).forEach { j ->
            if (graph[0][j] != 0) {
                isVisited[j] = true
                placePlayers(1, graph[0][j])
                isVisited[j] = false
            }
        }
        println(max)
    }
}

private fun placePlayers(depth: Int, sum: Int) {
    if (depth == 11) {
        max = maxOf(max, sum)
        return
    }

    (0 until 11).forEach { j ->
        if (!isVisited[j] && graph[depth][j] != 0) {
            isVisited[j] = true
            placePlayers(depth + 1, sum + graph[depth][j])
            isVisited[j] = false
        }
    }
}
