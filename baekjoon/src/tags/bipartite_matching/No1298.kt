package tags.bipartite_matching

/**
 * https://www.acmicpc.net/problem/1298
 */
private lateinit var graph: Array<MutableList<Int>>
private lateinit var students: IntArray
private lateinit var computers: IntArray
private lateinit var isVisited: BooleanArray

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    graph = getGraph(m)
    students = IntArray(101)
    computers = IntArray(5001)

    var matches = 0
    (1..n).forEach { s ->
        isVisited = BooleanArray(101)
        if (bipartiteMatch(s)) {
            matches++
        }
    }
    println(matches)
}

private fun getGraph(m: Int): Array<MutableList<Int>> {
    val graph = Array(101) { mutableListOf<Int>() }
    repeat(m) {
        val (a, b) = readln().split(" ").map { it.toInt() }
        graph[a].add(b)
    }
    return graph
}

private fun bipartiteMatch(s: Int): Boolean {
    isVisited[s] = true
    graph[s].forEach { c ->
        if (computers[c] == 0 || (!isVisited[computers[c]] && bipartiteMatch(computers[c]))) {
            students[s] = c
            computers[c] = s
            return true
        }
    }
    return false
}
