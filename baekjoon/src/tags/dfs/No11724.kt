package tags.dfs

/**
 * https://www.acmicpc.net/problem/11724
 */
private lateinit var graph: MutableMap<Int, MutableList<Int>>
private lateinit var isVisited: BooleanArray

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    graph = mutableMapOf()
    repeat(n + 1) { graph[it] = mutableListOf() }
    repeat(m) {
        val (src, dest) = readln().split(" ").map { it.toInt() }
        graph[src]!!.add(dest)
        graph[dest]!!.add(src)
    }

    isVisited = BooleanArray(n + 1)

    var count = 0
    for (i in 1 until isVisited.size) {
        if (!isVisited[i]) {
            dfs(i)
            count++
        }
    }
    println(count)
}

private fun dfs(index: Int) {
    isVisited[index] = true
    for (n in graph[index]!!) {
        if (!isVisited[n]) {
            dfs(n)
        }
    }
}
