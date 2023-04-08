package tags.dfs

/**
 * https://www.acmicpc.net/problem/2606
 */
private lateinit var graph: Array<BooleanArray>
private lateinit var isVisited: BooleanArray
private var count = 0

fun main() {
    val computers = readln().toInt()
    graph = Array(computers + 1) { BooleanArray(computers + 1) }
    isVisited = BooleanArray(computers + 1)

    val n = readln().toInt()
    repeat(n) {
        val (s, d) = readln().split(" ").map { it.toInt() }
        graph[s][d] = true
        graph[d][s] = true
    }

    dfs(1)
    println(count - 1)
}

private fun dfs(index: Int) {
    isVisited[index] = true
    count++

    for (i in graph[index].indices) {
        if (!isVisited[i] && graph[index][i]) {
            dfs(i)
        }
    }
}
