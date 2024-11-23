package tags.bipartite_matching

/**
 * https://www.acmicpc.net/problem/11376
 */
private lateinit var graph: Array<MutableList<Int>>
private lateinit var staffs: Array<MutableList<Int>>
private lateinit var works: IntArray
private lateinit var isVisited: BooleanArray

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    graph = getGraph(n)
    staffs = Array(n + 1) { mutableListOf() }
    works = IntArray(m + 1)

    var matches = 0
    (1..n).forEach { s ->
        repeat(2) {
            isVisited = BooleanArray(n + 1)
            if (bipartiteMatch(s)) {
                matches++
            }
        }
    }
    println(matches)
}

private fun getGraph(n: Int): Array<MutableList<Int>> {
    val graph = Array(n + 1) { mutableListOf<Int>() }
    (1..n).forEach { i ->
        val input = readln().split(" ").map { it.toInt() }
        graph[i].addAll(input.drop(1))
    }
    return graph
}

private fun bipartiteMatch(s: Int): Boolean {
    isVisited[s] = true
    graph[s].forEach { w ->
        if (works[w] == 0 || (!isVisited[works[w]] && bipartiteMatch(works[w]))) {
            works[w] = s
            return true
        }
    }
    return false
}
