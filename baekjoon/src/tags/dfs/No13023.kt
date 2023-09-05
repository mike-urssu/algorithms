package tags.dfs

/**
 * https://www.acmicpc.net/problem/13023
 */
private lateinit var graph: Array<MutableList<Int>>
private lateinit var isVisited: BooleanArray
private var isExist = false

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    graph = Array(n) { mutableListOf() }
    repeat(m) {
        val (a, b) = readln().split(" ").map { it.toInt() }
        graph[a].add(b)
        graph[b].add(a)
    }
    isVisited = BooleanArray(n)

    for (i in 0 until n) {
        isVisited[i] = true
        dfs(i, 1)
        isVisited[i] = false

        if (isExist) {
            break
        }
    }

    if (isExist) {
        println(1)
    } else {
        println(0)
    }
}

private fun dfs(n: Int, count: Int) {
    if (count >= 5) {
        isExist = true
        return
    }

    for (i in graph[n]) {
        if (!isVisited[i]) {
            isVisited[i] = true
            dfs(i, count + 1)
            isVisited[i] = false
        }
    }
}
